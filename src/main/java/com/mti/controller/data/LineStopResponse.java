package com.mti.controller.data;

public class LineStopResponse extends AbstractResponse {

    private LineResponse line;
    private StopResponse stop;
    private int order;

    public LineStopResponse() {
    }

    public LineResponse getLine() {
        return line;
    }

    public void setLine(LineResponse line) {
        this.line = line;
    }

    public StopResponse getStop() {
        return stop;
    }

    public void setStop(StopResponse stop) {
        this.stop = stop;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
