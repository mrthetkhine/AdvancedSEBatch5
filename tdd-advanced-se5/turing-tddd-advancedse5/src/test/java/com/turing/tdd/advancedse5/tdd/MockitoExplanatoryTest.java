package com.turing.tdd.advancedse5.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class MockitoExplanatoryTest {
	
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
	}
}
