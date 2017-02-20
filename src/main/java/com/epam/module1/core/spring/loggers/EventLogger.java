package com.epam.module1.core.spring.loggers;

import com.epam.module1.core.spring.beans.Review;

public interface EventLogger {

	public void logEvent(Review review);
}
