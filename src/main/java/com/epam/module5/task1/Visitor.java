package com.epam.module5.task1;

public interface Visitor
{
	void visit(DVDRenting service);

	void visit(ApplianceRenting service);
}
