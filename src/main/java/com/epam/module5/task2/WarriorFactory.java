package com.epam.module5.task2;

import java.util.TreeMap;


public class WarriorFactory
{
	private static TreeMap<String, AbstractWarrior> map = new TreeMap<String, AbstractWarrior>();

	public static AbstractWarrior getClassFromFactory(String name)
	{
		if (map.containsKey(name))
		{
			return map.get(name);
		}
		else
		{
			WarriorType type = WarriorType.valueOf(name.toUpperCase());
			switch (type)
			{
				case OFFICER:
				{
					Officer officer = new Officer();
					map.put(name, officer);
					return officer;
				}
				case MARINE:
				{
					Marine marine = new Marine();
					map.put(name, marine);
					return marine;
				}
				default:
					throw new EnumConstantNotPresentException(WarriorType.class, type.name());
			}
		}
	}
}