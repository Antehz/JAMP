package com.epam.module5.task2;

import java.io.Serializable;


public class ExternalWarrior implements Serializable
{
	private AbstractWarrior warrior; // inneer part
	// external part
	private int health;
	private float xCoord;
	private float yCoord;
	private float zCoord;

	public ExternalWarrior(String type, float xCoord, float yCoord, float zCoord)
	{
		this.warrior = WarriorFactory.getClassFromFactory(type);
		health = 180;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
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