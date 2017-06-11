package com.epam.module17.task;

public class Task2 {

	int count = 0;

	public static void main(String[] args) {
		Task2 test2Class = new Task2();
		new Thread(() -> {
			for (int i = 0; i < 999999; i++)
				test2Class.count--;
		}).start();

		new Thread(() -> {
			for (int i = 0; i < 999999; i++)
				test2Class.count++;
		}).start();

		System.out.println("Count = " + test2Class.count);
	}
}
