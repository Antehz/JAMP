package com.epam.module5.task2;

import java.util.ArrayList;


public class FlyweightRunnerBad
{
	private final static int SIZE = 3000000;

	public static void main(String[] args)
	{
		ArrayList<ExternalWarriorBad> legion = new ArrayList<ExternalWarriorBad>();
		int count=0;
		try
		{
			for (int i = 0; i < SIZE; i++)
			{
				legion.add(new ExternalWarriorBad(12.3f, 10.1f, 5.0f));
				count=i;
			}
		}
		catch (OutOfMemoryError e)
		{
			System.err.println("OutOfMemoryError for warrior Officer");
		}
		finally
		{
			System.out.println("Instance: " + count);
		}
	}
}