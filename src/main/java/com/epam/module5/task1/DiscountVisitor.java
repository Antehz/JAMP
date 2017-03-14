package com.epam.module5.task1;


public class DiscountVisitor implements Visitor
{

	public void visit(DVDRenting service)
	{
		System.out.println("Discount DVD renting service");
	}

	public void visit(ApplianceRenting service)
	{
		System.out.println("Discount Appliance renting service");
	}
}