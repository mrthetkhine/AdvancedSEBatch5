package com.turing.tdd.advancedse5.tdd;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class MockVsSpyTest {
	@Test
	public void testMock()
	{
		ArrayList mock = Mockito.mock(ArrayList.class);
		mock.add("one");
		mock.add("two");
		
		log.info("size "+mock.size());
		
		ArrayList list = new ArrayList<>();
		ArrayList spy = Mockito.spy(list);
		spy.add("One");
		spy.add("Two");
		
		when(spy.size()).thenReturn(100);
		log.info("Spy size " + spy.size());
	}
}
