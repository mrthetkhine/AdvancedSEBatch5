package com.turing.tdd.advancedse5.tdd;

public class Computer {

	public void start()
	{
		this.readBootSector();
		this.loadIntoMemory();
		this.runInCpu();
	}
	void readBootSector()
	{
		System.out.println("Read boot sector");
	}
	void loadIntoMemory()
	{
		System.out.println("loadIntoMemory");
	}
	void runInCpu()
	{
		System.out.println("run in CPU");
	}
}
