package com.mti.service.data;

/**
 * Link a bus stop to a bus line, with the number of the stop relative to the other stops in the line.
 */
public class LineStopEntity extends Entity {

    private LineEntity line;
    private StopEntity stop;
    private int order;

    public LineStopEntity() {
    }

    public LineEntity getLine() {
        return line;
    }

    public void setLine(LineEntity line) {
        this.line = line;
    }

    public StopEntity getStop() {
        return stop;
    }

    public void setStop(StopEntity stop) {
        this.stop = stop;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
