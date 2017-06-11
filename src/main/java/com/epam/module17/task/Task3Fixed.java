package com.epam.module17.task;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Task3Fixed {

	ConcurrentHashMap<Integer, Integer> hashMap = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		Task3Fixed task3 = new Task3Fixed();

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
