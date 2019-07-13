package com.mti.service;

import com.mti.model.dao.SlotDao;
import com.mti.model.data.SlotModel;
import com.mti.service.convertor.SlotEntityModelConverter;
import com.mti.service.data.SlotEntity;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.*;
import java.util.stream.Collectors;

@Singleton
public class SlotService extends Service<SlotEntity, SlotModel, SlotDao> {

    @Inject
    public SlotService(SlotDao dao, SlotEntityModelConverter converter) {
        super(dao, converter);
    }

    @Override
    public SlotEntity create(SlotEntity entity) {
        if (cantInsertSlot(entity)) {
            throw new IllegalArgumentException("can't create this slot, too many slot for the same driver");
        }

        return super.create(entity);
    }

    @Override
    public SlotEntity update(int id, SlotEntity entity) {
        if (cantInsertSlot(entity)) {
            throw new IllegalArgumentException("can't create this slot, too many slot for the same driver");
        }

        return super.update(id, entity);
    }

    /**
     * Check if all condition are valid to insert a slot
     *
     * @param slot slot to insert
     * @return is it possible to insert the slot
     */
    private boolean cantInsertSlot(SlotEntity slot) {

        // We get all slots related to the driver which is not our actual slot (to handle update)
        List<SlotEntity> slotsFromDriver = dao.getAllSlotFromDriver(slot.getDriver().getId())
                .stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.getId().equals(slot.getId()))
                .map(converter::modelToEntity)
                .collect(Collectors.toList());

        // And we do our check
        return alreadyWorkThisDay(slot.getDate(), slotsFromDriver)
                || !canWorkThisDay(slot.getDate(), slotsFromDriver);
    }

    /**
     * Check if the driver is already working today
     *
     * @param date  date of the slot we want to add
     * @param slots other slots of the driver
     * @return true if there is another slot this day
     */
    private boolean alreadyWorkThisDay(Date date, List<SlotEntity> slots) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        return slots.stream().anyMatch(s -> {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(s.getDate());
            return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
                    && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        });
    }

    /**
     * Check if there isn't more than 4 consecutive days of work and that the 2 day break
     * after 4 days work is correct
     *
     * @param date  date of the slot we want to add
     * @param slots other slots of the driver
     * @return true if adding a slot don't break any rule
     */
    private boolean canWorkThisDay(Date date, List<SlotEntity> slots) {

        // We don't have to check days that are to distant of the day we check so we keep only
        // the precedent and next week
        List<Date> relevantDate =
                slots.stream()
                        .filter(s -> {
                            int daysDiff = daysBetween(date, s.getDate());
                            return (daysDiff < 7);
                        }).map(SlotEntity::getDate)
                        .collect(Collectors.toList());

        // we add the our date to the relevant dates to simplify the check
        relevantDate.add(date);

        // We them sort the day to simplify check
        Collections.sort(relevantDate);

        // And we start the check
        return verifyDateSequence(relevantDate);
    }

    /**
     * Useful tool to calculate the number of day between two days
     *
     * @param d1 first day
     * @param d2 second day
     * @return the number of days between the two days
     */
    private int daysBetween(Date d1, Date d2) {
        return Math.abs((int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24)));
    }

    /**
     * Verify in a list of sorted days if there isn't more than 4 consecutive days and
     * If after 4 days of work there is a break of 2 days
     *
     * @param dates list of sorted dates representing days
     * @return true if the rule are verified
     */
    private boolean verifyDateSequence(List<Date> dates) {
        int consecutiveWorkDay = 1;
        Date lastDate = null;
        for (Date date : dates) {
            // check first iteration of our loop
            if (lastDate == null) {
                lastDate = date;
                continue;
            }

            int daysDiff = daysBetween(lastDate, date);

            if (daysDiff <= 1) {
                // Test the rule "no more than 4 consecutive work days"
                if (consecutiveWorkDay == 4)
                    return false;
                consecutiveWorkDay += 1;
            } else {
                // Test the rule "2 break day after 4 work days"
                if (consecutiveWorkDay == 4 && daysDiff <= 2) {
                    return false;
                }
                consecutiveWorkDay = 1;
            }
            lastDate = date;
        }
        return true;
    }


}
