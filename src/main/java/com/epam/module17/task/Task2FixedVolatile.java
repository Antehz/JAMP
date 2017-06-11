package com.epam.module17.task;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Task2FixedVolatile {

    AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Task2FixedVolatile test3Class = new Task2FixedVolatile();

        Date date1 = new Date();
       Thread thread1 = new Thread(() -> {
            for (int i=0; i<9999999; i++)
                    test3Class.count.decrementAndGet();
        });

        Thread thread2 =  new Thread(() -> {
            for (int i=0; i<9999999; i++)
                    test3Class.count.incrementAndGet();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        Date date2 = new Date();
        Long time =date2.getTime()-date1.getTime();
        System.out.println("Count =  : " + test3Class.count);
        System.out.println("Time : " + time);
    }
}

