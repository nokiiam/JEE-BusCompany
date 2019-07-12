package com.mti.controller.data;

public class LineStopResponse extends AbstractResponse {

    private Integer line;
    private Integer stop;
    private int order;

    public LineStopResponse() {
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
