package com.logUtils;

public abstract class AbstractLogHandler implements LogHandler {

    private LogHandler next;

    @Override
    public void setNext(LogHandler handler) {
        this.next = handler;
    }

    @Override
    public LogHandler getNext(){
        return next;
    }

}
