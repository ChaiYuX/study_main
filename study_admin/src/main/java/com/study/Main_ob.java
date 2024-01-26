package com.study;

public class Main_ob {

    public static void main(String[] args) {
        methodA();
    }

    public static void methodA() {
        methodB();
    }

    public static void methodB() {
        printCallerInfo();
    }

    public static void printCallerInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 4) {
            StackTraceElement caller = stackTrace[3];
            String className = caller.getClassName();
            String methodName = caller.getMethodName();
            int lineNumber = caller.getLineNumber();

            System.out.println("Caller Class: " + className);
            System.out.println("Caller Method: " + methodName);
            System.out.println("Caller Line Number: " + lineNumber);
        }
    }

    /*public static void main(String[] args) {
        ObservedUser user = new ObservedUser();
        ObserveUser1 observe1 = new ObserveUser1();
        ObserveUser2 observe2 = new ObserveUser2();
        user.registerObserver(observe1);
        user.registerObserver(observe2);
        user.observerAction();
        user.removeObserver(observe2);
        user.removeObserver(observe1);
    }*/

}
