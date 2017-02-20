package com.epam.module1.core.impl;

import com.epam.module1.core.ReviewRatingService;
import com.epam.module1.core.spring.beans.CommentType;

//Separate service from Event class
public class DefaultReviewRatingService implements ReviewRatingService {

	CommentType result = CommentType.NEUTRAL;

	public CommentType evaluate(int rating) {

		if (rating < 2) {
			result = CommentType.NEGATIVE;
		}
		if (rating > 4) {
			result = CommentType.POSITIVE;
		}

		return result;
	}
}
