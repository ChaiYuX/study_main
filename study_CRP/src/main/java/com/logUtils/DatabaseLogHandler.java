package com.logUtils;

public class DatabaseLogHandler extends AbstractLogHandler{

    @Override
    public void handle(LogLevel level, String message) {

        if (level == LogLevel.WARNING){
            // write to database
            System.out.println("Writing warning message to database: " + message);
        } else{
            getNext().handle(level , message);
        }

    }

}
