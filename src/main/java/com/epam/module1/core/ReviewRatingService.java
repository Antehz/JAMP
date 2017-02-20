package com.epam.module1.core;

import com.epam.module1.core.spring.beans.CommentType;

public interface ReviewRatingService {

	CommentType evaluate(int rating);

}
