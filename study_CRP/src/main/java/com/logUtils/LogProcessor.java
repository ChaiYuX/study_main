package com.logUtils;

public class LogProcessor {

    private LogHandler handlerChain;

    public LogProcessor(){
        handlerChain = new ConsoleLogHandler();
        handlerChain.setNext(new FaileLogHandler("log.text"));
        handlerChain.getNext().setNext(new DatabaseLogHandler());
    }

    public void processLog(LogLevel logLevel , String message){
        handlerChain.handle(logLevel , message);
    }

}
