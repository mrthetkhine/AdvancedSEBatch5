package com.turing.tdd.advancedse5.tdd;

public class CarClient {
	public static void main(String[]args)
	{
		Engine engine = new DieselEngine();
		Car car = new Car(engine);
		car.start();
	}
}
