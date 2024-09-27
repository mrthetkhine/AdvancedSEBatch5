package com.turing.tdd.advancedse5.tdd;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;




@ExtendWith(MockitoExtension.class)
@Slf4j
public class ExplanatoryTest {

	
	@BeforeAll
	public static void testBeforeAll()
	{
		log.info("Before all");
	}
	
	@AfterAll
	public static void testAfterAll()
	{
		log.info("After all");
	}
	@BeforeEach
	public void beforeEach()
	{
		log.info("Before each");
	}
	@AfterEach
	public void afterEach()
	{
		log.info("@AfterEach ");
	}
	@DisplayName("Test stack push")
	@Test
	public void testStackPush()
	{
		log.info("Test push "+this);
		
		//Arrange
		Stack<Integer> stack = new Stack<>();
		int size = stack.size();
		
		//Act
		stack.push(100);
		
		//Assert
		assertAll("Test push",
		        () -> assertEquals(size+1, stack.size()),
		        () -> assertEquals(100, stack.pop())
		    );
		
		
		
	}
	//@RepeatedTest(5)     
	@Test
	public void testAnother()
	{
		String str ="";
		assertNotNull(str);
		log.info("Test Another");
	}
	
	//@Test
	
}
