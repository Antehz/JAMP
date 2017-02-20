package com.epam.module1.core;

import com.epam.module1.core.spring.beans.Review;

public interface CommentService {
	void writeComment(Review review);

	boolean removeComment(int id);
}
