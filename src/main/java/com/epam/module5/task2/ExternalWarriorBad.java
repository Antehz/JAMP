package com.epam.module5.task2;

import java.io.Serializable;


public class ExternalWarriorBad implements Serializable
{
	private int health;
	private float xCoord;
	private float yCoord;
	private float zCoord;
	protected Integer strength;
	protected Integer dexterity;
	protected Integer speed;
	protected Integer intelligence;
	long[] l = new long[349999990];

	public ExternalWarriorBad(float xCoord, float yCoord, float zCoord)
	{
		health = 180;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
		strength=10;
		dexterity=20;
		speed=1;
		intelligence=2;
	}

	public void go()
	{
		// more code here
	}

	public void fight()
	{
		// more code here
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public float getXCoord()
	{
		return xCoord;
	}

	public void setXCoord(float xCoord)
	{
		this.xCoord = xCoord;
	}

	public float getYcoord()
	{
		return yCoord;
	}

	public void setYcoord(float ycoord)
	{
		this.yCoord = ycoord;
	}

}