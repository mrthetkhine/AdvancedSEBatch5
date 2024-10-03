package com.turing.tdd.advancedse5.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class MockitoStubbingTest {
	ArrayList mock = Mockito.mock(ArrayList.class);
	@Test
	public void testStubConsecutiveCall()
	{
		
		when(mock.get(1))
		   .thenThrow(new RuntimeException())
		   .thenReturn("one","two","three");

		 assertThrows(RuntimeException.class,()->{
			 mock.get(1);
		 });
		

		 assertEquals("one", mock.get(1));

		 //Any consecutive call: prints "foo" as well (last stubbing wins).
		 log.info("Mock.get(1) 2nd"+mock.get(1));
		 log.info("Mock.get(1) third "+mock.get(1));
		 log.info("Mock.get(1) fourth call "+mock.get(1));
	}
	
	@Test 
	public void testReturnWithCallBack()
	{
		when(mock.get(anyInt()))
			.thenAnswer(
			     new Answer() {
			    	 @Override
			         public Object answer(InvocationOnMock invocation)throws Throwable {
			    		 log.info("called answer");
			             Object[] args = invocation.getArguments();
			             Object mock = invocation.getMock();
			             return "called with arguments: " + Arrays.toString(args);
			         }
					
			 });
		log.info("mock get(1) "+mock.get(1));
	}
	@Test
	public void testReturnMethod()
	{
		doThrow(new RuntimeException()).when(mock).clear();
		assertThrows(RuntimeException.class,()->{
			mock.clear();
		});
		
		doReturn("hello").when(mock).get(0);
		assertEquals("hello",mock.get(0));
	}
	@Test
	public void testDoNothing()
	{
		LinkedList list = new LinkedList();
		LinkedList spy = Mockito.spy(list);
	
		//let's make clear() do nothing
		doNothing().when(spy).clear();
	
		spy.add("one");
	
		//clear() does nothing, so the list still contains "one"
		spy.clear();
		log.info("Do Nothing size "+spy.size());
	}
	@Test
	public void testDoCallRealMethod()
	{
		Engine engine = mock(Engine.class);
		Car car = new Car(engine);
		
		doCallRealMethod().when(engine).start();
		car.start();
	}
}
