package com.epam.module17.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class Task1ExecutirService {

	private static Function<Long, Long> calcFactorial = integer -> {
		Long fact = 1L; // this will be the result
		for (int i = 1; i <= integer; i++) {
			fact *= i;
		}
		return fact;
	};

	public static void main(String[] args) {
		ExecutorService executorService3 = Executors.newFixedThreadPool(5);
		executorService3.execute(() -> {
			System.out.println("Thread started");
			Long a = a(9999L);
			Long b = b(a);
			Long c = c(b);
			Long d = d(c + b);
			System.out.format("a=%d b=%d c=%d d=%d\n", a, b, c, d);
		});
	}

	public static Long a(Long number) {
		return calcFactorial.apply(number);
	}

	public static Long b(Long number) {
		return calcFactorial.apply(number);
	}

	public static Long c(Long number) {
		return calcFactorial.apply(number);
	}

	public static Long d(Long number) {
		return calcFactorial.apply(number);
	}
}
