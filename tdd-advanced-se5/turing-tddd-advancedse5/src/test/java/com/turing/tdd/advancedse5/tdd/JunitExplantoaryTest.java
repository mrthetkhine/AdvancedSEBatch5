package com.turing.tdd.advancedse5.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;
import com.turing.tdd.advancedse5.Stack;
import com.turing.tdd.advancedse5.StackOverflowException;
import com.turing.tdd.advancedse5.Task;
@ExtendWith(MockitoExtension.class)
@Slf4j
public class JunitExplantoaryTest {

	@Test
	public void testOverflow()
	{
		Stack stack = new Stack();
		for(int i=0;i< 10;i++)
		{
			stack.push(i);
		}
		StackOverflowException exception = assertThrows(StackOverflowException.class, () ->{
			stack.push(100);
		});
		assertEquals("Stackoverflow",exception.getMessage());
		
	}
	@Test
	public void testOverflowAssertThrowExactly()
	{
		Stack stack = new Stack();
		for(int i=0;i< 10;i++)
		{
			stack.push(i);
		}
		StackOverflowException exception = assertThrowsExactly(StackOverflowException.class, () ->{
			stack.push(100);
		});
		assertEquals("Stackoverflow",exception.getMessage());
		
	}
	@Test
	public void testTimeout()
	{
		Task task = new Task();
		assertTimeout(ofSeconds(2), () -> {
            task.doSomething(1500);
        });
	}
	@Disabled
	@Test
	public void testTimeoutWithResult()
	{
		Task task = new Task();
		int result = assertTimeout(ofSeconds(2), () -> {
            return task.getData(1500);
        });
		assertEquals(100,result);
	}
	@Test
	@Order(2)
	public void testOrderTwo()
	{
		log.info("Test Order(2)");
	}
	//@EnabledOnOs(MAC)
	@Test
	@Order(1)
	public void testOrderOne()
	{
		log.info("Test Order(1)");
	}
	
}
