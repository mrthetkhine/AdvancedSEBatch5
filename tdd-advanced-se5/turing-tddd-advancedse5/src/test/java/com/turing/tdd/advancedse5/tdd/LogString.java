package com.turing.tdd.advancedse5.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class LogString extends Computer{
	String logStr = "";
	
	@Test
	void testSequnce()
	{
		Computer computer = this;
		computer.start();
		
		assertEquals("readBootSector,loadIntoMemory,runInCpu",logStr);
	}
	void readBootSector()
	{
		logStr +="readBootSector,";
	}
	void loadIntoMemory()
	{
		logStr +="loadIntoMemory,";
	}
	void runInCpu()
	{
		logStr +="runInCpu";
	}
}
