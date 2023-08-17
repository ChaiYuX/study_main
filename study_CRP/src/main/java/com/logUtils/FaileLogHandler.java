package com.logUtils;

public class FaileLogHandler extends AbstractLogHandler{

    private String fileName;

    public FaileLogHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void handle(LogLevel level, String message) {

        if (level == LogLevel.ERROR){
            // write to file
            System.out.println("Writing error message to file " + fileName + ": " + message);
        } else{
            getNext().handle(level , message);
        }

    }

}
