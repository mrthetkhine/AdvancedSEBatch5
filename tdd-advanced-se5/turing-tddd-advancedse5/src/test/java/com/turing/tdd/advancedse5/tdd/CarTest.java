package com.turing.tdd.advancedse5.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class CarTest {

	@Mock
	Engine engine;
	
	@Test
	public void testCar()
	{
		//Engine engine = mock(Engine.class);
		Car car = new Car(engine);
		
		car.start();
		verify(engine).start();
	}
	
	class MockedEngine extends Engine
	{
		boolean started ;
		
		@Override
		public void start()
		{
			this.started = true;
		}
	}
	@Test
	public void testCarManualMock()
	{
		MockedEngine engine = new MockedEngine();
		Car car = new Car(engine);
		
		car.start();
		assertEquals(true,engine.started);
	}
}
