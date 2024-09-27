package com.turing.tdd.advancedse5.tdd;

public class Engine {
	public void start()
	{
		System.out.println("Engine start");
	}
}
class DieselEngine extends Engine
{
	public void start()
	{
		System.out.println("DieselEngine start");
	}
}