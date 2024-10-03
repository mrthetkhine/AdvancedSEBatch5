package com.turing.tdd.advancedse5.tdd;

public class Engine {
	public Engine()
	{
		System.out.println("Engine constructor");
	}
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