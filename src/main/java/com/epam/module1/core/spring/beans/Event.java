package com.epam.module1.core.spring.beans;

import java.text.DateFormat;
import java.util.Date;

//violation one responsibility
public class Event {

	private static int id;
	private Date date;
	private DateFormat df;

	public Event(Date date, DateFormat df) {
		super();
		this.date = date;
		this.df = df;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "[date=" + date+"]";
	}
	
	
}
