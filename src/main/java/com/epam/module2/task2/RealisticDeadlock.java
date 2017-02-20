package com.epam.module2.task2;

public class RealisticDeadlock {
	public static void main(String[] args) {
		final String resource1 = "resource1";
		final String resource2 = "resource2";
		
		Thread t1 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1: locked resource 1");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource2) {
						System.out.println("Thread 1: locked resource 2");
					}
				}
			}
		};

	
		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2: locked resource 2");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}

					synchronized (resource1) {
						System.out.println("Thread 2: locked resource 1");
					}
				}
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 3: locked resource 2");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}
				}
			}
		};
		
		Thread t4 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 4: locked resource 2");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}
				}
			}
		};
		
		Thread t5 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 5: locked resource 1");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}
				}
			}
		};
		
		Thread t6 = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 6: locked resource 1");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
					}
				}
			}
		};

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();

	}
}