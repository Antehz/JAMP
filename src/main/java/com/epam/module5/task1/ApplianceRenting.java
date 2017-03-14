package com.epam.module5.task1;

public class ApplianceRenting extends Renting
{
	private double redemptionPrice;

	public double getRedemptionPrice()
	{
		return redemptionPrice;
	}

	public void setRedemptionPrice(double redemptionPrice)
	{
		this.redemptionPrice = redemptionPrice;
	}

	public void calculate(Visitor v)
	{
		// some code here
		v.visit(this);
	}
}