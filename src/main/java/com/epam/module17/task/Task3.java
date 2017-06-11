package com.epam.module17.task;

import java.util.HashMap;

public class Task3 {

	HashMap<Integer, Integer> hashMap = new HashMap<>();

	public static void main(String[] args) {
		Task3 task3 = new Task3();

		new Thread(() -> {
            while (true)
			task3.hashMap.values().stream().mapToInt(Number::intValue).sum();
		}).start();

		new Thread(() -> {
			int s = 0;
			while (true) {
				s++;
				task3.hashMap.put(s, s);
			}
		}).start();

		System.out.println();
	}
}
