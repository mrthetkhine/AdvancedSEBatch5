package com.turing.tdd.advancedse5.tdd;

public class Compute {
	public void somethod(int miliseconds) {
		
		try
		{
			Thread.sleep(miliseconds);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Done after "+miliseconds+" ms");
	}
}
