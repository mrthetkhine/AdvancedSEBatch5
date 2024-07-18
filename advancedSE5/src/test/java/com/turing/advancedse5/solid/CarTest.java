/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.solid;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 *
 * @author macbook
 */
public class CarTest {
    @Test
    public void testCar()
    {
        Engine engine = Mockito.mock(Engine.class);
        
        Car car = new Car(engine);
        car.start();
        
        Mockito.verify(engine).start();
    }
}
