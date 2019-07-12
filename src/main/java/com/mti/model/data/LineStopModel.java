package com.mti.model.data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bus_line_stop")
public class LineStopModel extends Model {

    @ManyToOne
    @JoinColumn(name = "bus_line_id", referencedColumnName = "id", nullable = false)
    private LineModel line;

    @ManyToOne
    @JoinColumn(name = "bus_stop_id", referencedColumnName = "id", nullable = false)
    private StopModel stop;

    private int order;

    public LineStopModel() {
    }

    public LineStopModel(LineModel line, StopModel stop, int order) {
        this.line = line;
        this.stop = stop;
        this.order = order;
    }

    public LineModel getLine() {
        return line;
    }

    public void setLine(LineModel line) {
        this.line = line;
    }

    public StopModel getStop() {
        return stop;
    }

    public void setStop(StopModel stop) {
        this.stop = stop;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
