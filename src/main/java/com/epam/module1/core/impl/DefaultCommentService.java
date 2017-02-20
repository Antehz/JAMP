package com.epam.module1.core.impl;

import java.util.HashMap;

import com.epam.module1.core.CommentService;
import com.epam.module1.core.ReviewRatingService;
import com.epam.module1.core.spring.beans.Client;
import com.epam.module1.core.spring.beans.CommentType;
import com.epam.module1.core.spring.beans.Event;
import com.epam.module1.core.spring.beans.Review;
import com.epam.module1.core.spring.loggers.EventLogger;

//violation of (Single-Responsibility Principle We can't even guess the adecvate name of class
public class DefaultCommentService implements CommentService {

	private Client client;
	private Event event;
	private HashMap<String, EventLogger> loggerMap;
	private ReviewRatingService reviewRatingService;
    private final static String DEFAULT = "default";
	
    public DefaultCommentService(Event event) {
		super();
		this.event = event;
	}

	public void writeComment(Review review) {
		review.setEvent(event);
		EventLogger eventLogger = initEventLogger(review);
		eventLogger.logEvent(review);
	}

	//module
	//implement IoC pattern
	private EventLogger initEventLogger(Review review) {
		//reduce coupling
		EventLogger eventLogger = loggerMap.get(getRating(review).toString());
		if (eventLogger==null){
			eventLogger = loggerMap.get(DEFAULT);
		}
		return eventLogger;
	}

	private CommentType getRating(Review review) {
		return reviewRatingService.evaluate(review.getRating());
	}

	public void setLoggerMap(HashMap<String, EventLogger> loggerMap) {
		this.loggerMap = loggerMap;
	}

	public void setReviewRatingService(ReviewRatingService reviewRatingService) {
		this.reviewRatingService = reviewRatingService;
	}

	public boolean removeComment(int id) {
		return false;
	}
	
	//violation of (Single-Responsibility Principle, SRP) 
}
