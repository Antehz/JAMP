package com.epam.module5.task2;

public abstract class AbstractWarrior
{
	protected Integer strength;
	protected Integer dexterity;
	protected Integer speed;
	protected Integer intelligence;
	long[] l = new long[349999990];

	public int getStrength()
	{
		return strength;
	}

	public void setStrength(int strength)
	{
		this.strength = strength;
	}

	public int getDexterity()
	{
		return dexterity;
	}

	public void setDexterity(int dexterity)
	{
		this.dexterity = dexterity;
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
}