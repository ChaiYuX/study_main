package com.logUtils;

public interface LogHandler {

    void setNext(LogHandler logHandler);

    LogHandler getNext();

    void handle(LogLevel level , String message);

}
