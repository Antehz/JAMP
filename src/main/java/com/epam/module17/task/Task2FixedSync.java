package com.epam.module17.task;

import java.util.Date;

public class Task2FixedSync {

    int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Task2FixedSync test2Class = new Task2FixedSync();
		Date date1 = new Date();

		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 9999999; i++)
				synchronized (test2Class) {
					test2Class.count--;
				}
		});

		Thread thread2 =new Thread(() -> {
			for (int i = 0; i < 9999999; i++)
				synchronized (test2Class) {
					test2Class.count++;
				}
		});

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		Date date2 = new Date();

		Long time = date2.getTime() - date1.getTime();
		System.out.println("Count =  : " + test2Class.count);
		System.out.println("Time : " + time);
	}
}
