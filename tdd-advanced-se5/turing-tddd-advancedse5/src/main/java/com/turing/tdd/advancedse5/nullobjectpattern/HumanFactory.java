package com.turing.tdd.advancedse5.nullobjectpattern;

import java.util.HashMap;
import java.util.Optional;

class NullObject extends Human
{

	NullObject(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	void display()
	{
	}
	
}
public class HumanFactory {

	private HashMap<String,Human> map;
	
	HumanFactory()
	{
		this.map = new HashMap<>();
		this.map.put("Aung Aung", new Human("Aung Aung"));
		this.map.put("Hla Aung", new Human("Hla Aung"));
	}
	Human getHuman(String name)
	{
		if(name==null || name.isEmpty())
		{
			return new NullObject(null);
		}
		else
		{
			return this.map.get(name);
		}
	}
	Optional<Human> getHumanV2(String name)
	{
		Human value = this.map.get(name);
		return Optional.ofNullable(value);
	}
}
