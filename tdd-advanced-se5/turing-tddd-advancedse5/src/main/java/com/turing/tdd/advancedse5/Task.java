package com.turing.tdd.advancedse5;



import lombok.extern.slf4j.Slf4j;


public class Task {
	public void doSomething(long delay)
	{
		try
		{
			System.out.println("Started task");
			Thread.sleep(delay);
			System.out.println("end task");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public int getData(long delay)
	{
		try
		{
			System.out.println("Started getData task");
			Thread.sleep(delay);
			System.out.println("end getData task");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 100;
	}
}
