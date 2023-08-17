package com.logUtils;

public class ConsoleLogHandler extends AbstractLogHandler{


    @Override
    public void handle(LogLevel level, String message) {

        if (level == LogLevel.INFO){
            System.out.println(message);
        } else{
            getNext().handle(level , message);
        }

    }

}
