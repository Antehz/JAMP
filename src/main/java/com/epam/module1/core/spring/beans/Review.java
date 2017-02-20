package com.epam.module1.core.spring.beans;

public class Review {

	private Client client;
	private Event event;
	private String message;
	private CommentType commentType;
	private int rating;

	public Review(Client client, String message, int rating) {
		super();
		this.client = client;
		this.message = message;
		this.rating=rating;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CommentType getCommentType() {
		return commentType;
	}

	public void setCommentType(CommentType commentType) {
		this.commentType = commentType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [client=" + client + ", event=" + event + ", message=" + message + ", commentType=" + commentType
				+ ", rating=" + rating + "]";
	}


}
