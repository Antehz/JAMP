package com.epam.module5.task1;

public class StandardVisitor implements Visitor
{

	public void visit(DVDRenting service)
	{
		System.out.println("Standard DVD renting service");
	}

	public void visit(ApplianceRenting service)
	{
		System.out.println("Standard Appliance renting service");
	}
}