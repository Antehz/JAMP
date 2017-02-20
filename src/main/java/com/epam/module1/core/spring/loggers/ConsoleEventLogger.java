package com.epam.module1.core.spring.loggers;

import com.epam.module1.core.spring.beans.Review;

public class ConsoleEventLogger implements EventLogger {

	public void logEvent(Review review) {
		System.out.println(review);
	}
}
