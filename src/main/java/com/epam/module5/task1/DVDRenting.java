package com.epam.module5.task1;

;


public class DVDRenting extends Renting
{
	private int numberDisks;

	public int getNumberDisks()
	{
		return numberDisks;
	}

	public void setNumberDisks(int numberDisks)
	{
		this.numberDisks = numberDisks;
	}


	public void calculate(Visitor v)
	{
		// some code here
		v.visit(this);
	}
}