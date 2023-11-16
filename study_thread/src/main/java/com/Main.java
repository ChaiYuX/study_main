package com;

import java.util.concurrent.TimeUnit;

public class Main {
    public static int num = 10;
    public static void main(String[] args) throws InterruptedException {
// 开3个线程循环读num变量的值, 当num < 1线程就结束
        for (int i = 0; i < 3; i++) {
//            int finali = i;
            Thread thread = new Thread(() -> {
                while (true) {
                    if (num < 1) return;
//                    System.out.println(finali);

                    // 等待200毫秒
                    //          try { TimeUnit.MILLISECONDS.sleep(1); }
                    //          catch (InterruptedException e) { e.printStackTrace(); }
                    Thread.yield();
                }
            }, String.valueOf(i));
            thread.start();
            if (i == 2) {
                Thread thread3 = new Thread(() -> {
                    //持续监测线程状态
                    while (true) {
                        //只获取到自己这个线程的线程组
                        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                        Thread[] threads = new Thread[threadGroup.activeCount()];
                        //获取所有的线程组
                        threadGroup.enumerate(threads);
                        for(Thread info : threads) {
                            if (info.getName().equals("0") && info.getState() == Thread.State.TERMINATED) {
                                System.out.println("thread 0 的状态：" + info.getState());
                            }
                            if (info.getName().equals("1") && info.getState() == Thread.State.TERMINATED) {
                                System.out.println("thread 1 的状态：" + info.getState());
                            }
                            if (info.getName().equals("2") && info.getState() == Thread.State.TERMINATED) {
                                System.out.println("thread 2 的状态：" + info.getState());
                            }
                        }
                        if (threads.length <= 0){
                            break;
                        }
                    }
                }, String.valueOf(3));
            }
        }
        TimeUnit.MILLISECONDS.sleep(200);
        for (int i = 0; i < 100000; i++) {
            num--;
        }
        System.out.println("最终: num = " + num);




    }
}