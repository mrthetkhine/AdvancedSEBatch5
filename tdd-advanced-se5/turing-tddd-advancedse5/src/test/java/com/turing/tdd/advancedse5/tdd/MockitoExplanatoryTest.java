package com.turing.tdd.advancedse5.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class MockitoExplanatoryTest {
	
	List mockedList = Mockito.mock(ArrayList.class);
	@Test
	public void testMockito()
	{	
		List mockList = Mockito.mock(ArrayList.class);
	
		mockList.add("one");
		mockList.clear();
		Mockito.verify(mockList).add("one");
		Mockito.verify(mockList).clear();
		log.info("mockito test ");
		
		Mockito.when(mockList.get(0)).thenReturn("two");
		String result = (String)mockList.get(0);
		assertEquals("two",result);
		
		log.info("get(100) "+mockList.get(100));
	}
	
	@Test
	public void testArgumentMatcher()
	{
		
		when(mockedList.get(anyInt())).thenReturn("element");
		
		assertEquals("element",mockedList.get(0));
		//assertEquals("element",mockedList.get(900));
		
		verify(mockedList).get(anyInt());
		

		mockedList.add("hell0");
		verify(mockedList).add(argThat((String someString) -> someString.length() >= 5));
	}
	@Test
	public void testExactInvocationNumber()
	{
		 mockedList.add("once");

		 mockedList.add("twice");
		 mockedList.add("twice");

		 mockedList.add("three times");
		 mockedList.add("three times");
		 mockedList.add("three times");
		 mockedList.add("three times");
		 //mockedList.add("three times");
		 //mockedList.add("three times");
		 
		 //verify(mockedList).add("once");
		 verify(mockedList, times(1)).add("once");
		 verify(mockedList, times(2)).add("twice");
		 //verify(mockedList, times(3)).add("three times");
		 
		 verify(mockedList, never()).add("never happened");
		 
		 verify(mockedList, atMostOnce()).add("once");
		 verify(mockedList, atLeastOnce()).add("three times");
		 verify(mockedList, atLeast(2)).add("three times");
		 verify(mockedList, atMost(5)).add("three times");
	}
	@Test
	void testMockException()
	{
		 doThrow(new RuntimeException()).when(mockedList).clear();
		 
		 RuntimeException exception = assertThrows(RuntimeException.class,()->{
			 mockedList.clear();
		 });
	}
	@Test
	void testInvocationOrder()
	{
		 List singleMock = mock(List.class);

		 //using a single mock
		 singleMock.add("was added first");
		 singleMock.add("was added second");

		 //create an inOrder verifier for a single mock
		 InOrder inOrder = Mockito.inOrder(singleMock);
		 inOrder.verify(singleMock).add("was added first");
		 inOrder.verify(singleMock).add("was added second");
		 
		 List firstMock = mock(List.class);
		 List secondMock = mock(List.class);
		 
		 firstMock.add("was called first");
		 secondMock.add("was called second");
		 
		 InOrder inOrder2 = Mockito.inOrder(firstMock, secondMock);

		 //following will make sure that firstMock was called before secondMock
		 inOrder2.verify(firstMock).add("was called first");
		 inOrder2.verify(secondMock).add("was called second");
	}
	
	@Test
	void testSomeMethodWereNeverCalled()
	{
		 List mockOne = mock(List.class);
		 mockOne.add("one");
		 //mockOne.add("two");
		 //ordinary verification
		 verify(mockOne).add("one");

		 //verify that method was never called on a mock
		 verify(mockOne, never()).add("two");

	}
	@Test
	void testNoMoreAdditionalCalled()
	{
		 mockedList.add("one");
		 //mockedList.add("two");
		 //log.info("Size "+ mockedList.size());
	
		 verify(mockedList).add("one");
	
		 //following verification will fail
		 verifyNoMoreInteractions(mockedList);

	}
	@Test
	public void testCaptureAgrument()
	{
		List mock = Mockito.mock(List.class);
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		
		mock.add("one");
		//mock.add("two");
		Mockito.verify(mock,atLeast(1)).add(argument.capture());
		log.info("Argument "+ argument.getValue());
		assertEquals("one",argument.getValue());
	}
	/*
	@Test
	public void testTimeout()
	{
		Compute compute = mock(Compute.class);
		try
		{
			Thread.sleep(100);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		compute.somethod(2500);
		verify(compute,timeout(200)).somethod(2500);
	}*/
}
