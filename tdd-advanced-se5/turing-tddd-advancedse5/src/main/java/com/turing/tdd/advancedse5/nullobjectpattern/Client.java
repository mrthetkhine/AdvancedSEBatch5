package com.turing.tdd.advancedse5.nullobjectpattern;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
	public static void main(String[]args)
	{
		HumanFactory factory = new HumanFactory();
		//Human h = factory.getHuman("");
		//h.display();
		Optional<Human> result = factory.getHumanV2(null);
		/*
		if(result.isPresent())
		{
			result.get().display();
		}*/
		result.map(h->{
			h.display();
			return h.name;
		});
	
	}
}
