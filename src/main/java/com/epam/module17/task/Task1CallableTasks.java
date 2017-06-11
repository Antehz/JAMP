package com.epam.module17.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;

public class Task1CallableTasks {

	public static Function<Long, Long> calcFactorial = integer -> {
		Long fact = 1L; // this will be the result
		for (int i = 1; i <= integer; i++) {
			fact *= i;
		}
		return fact;
	};

	Lock lock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(4);
		Long initialLOng = 333L;
		List<Worker> workers = new ArrayList<>();

		for (Long i = initialLOng; i < 999L; i++) {
			workers.add(new Worker(i));
		}
		List<Future<Long>> results = executor.invokeAll(workers);
		for (Future<Long> result : results)
			System.out.println(result.get());
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

class Worker implements Callable<Long> {

	Long aLong;

	public Worker(Long log) {
		this.aLong = log;
	}

	@Override
	public Long call() throws Exception {
		System.out.println("Thread started");
		Long a = Task1CallableTasks.a(999999999L);
		Long b = Task1CallableTasks.b(a);
		Long c = Task1CallableTasks.c(b);
		Long d = Task1CallableTasks.d(c + b);
		System.out.format("a=%d b=%d c=%d d=%d\n", a, b, c, d);
		System.out.println("Thread finished");
		return d;
	}
}
