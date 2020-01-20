package com.mathsigit.concurrency;

import java.util.concurrent.TimeUnit;

public class MainThread {
    public static void main(String[] args) {
        ThreadViaRun();
        ThreadWithoutRun();
    }

    private static void ThreadViaRun() {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };

        task.run();

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Done!");
    }

    private static void ThreadWithoutRun() {
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();
    }
}
