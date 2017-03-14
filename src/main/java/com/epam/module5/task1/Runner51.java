package com.epam.module5.task1;

public class Runner51
{
	public static void main(String[] args)
	{
		final int term = 5;
		final double redemptionPrice = 100;

		ApplianceRenting applianceRenting = new ApplianceRenting();
		applianceRenting.setRedemptionPrice(redemptionPrice);
		applianceRenting.setTerm(term);

		StandardVisitor standardVisitor = new StandardVisitor();

		applianceRenting.calculate(standardVisitor);
	}
}
