package com.epam.module5.task1;


public class PenaltyRateVisitor implements Visitor
{

	public void visit(DVDRenting service)
	{
		System.out.println("Penalty DVD renting service");
	}

	public void visit(ApplianceRenting service)
	{
		System.out.println("Penalty Appliance renting service");
	}
}