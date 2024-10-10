package com.turing.tdd.advancedse5.tdd;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class CrashTest {
	@Test
	public void testCrashException()
	{
		FullFile file = new FullFile("demo.txt");
		/*
		assertThrows(IOException.class,()->{
			file.createNewFile();
		});*/
		try
		{
			file.createNewFile();
			fail("IO Exception should be throwns");
		}
		catch(IOException e)
		{
			
		}
		
	}
}
