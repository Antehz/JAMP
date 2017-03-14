package com.epam.module5.task1;

public abstract class Renting implements Visitable
{
	private int term;

	public int getTerm()
	{
		return term;
	}

	public void setTerm(int term)
	{
		this.term = term;
	}
}