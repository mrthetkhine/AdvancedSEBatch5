package com.turing.tdd.advancedse5.nullobjectpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Human {
	String name;
	
	Human(String name)
	{
		this.name = name;
	}
	void display()
	{
		log.info("Name is "+name);
	}
}
