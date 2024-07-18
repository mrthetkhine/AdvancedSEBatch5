/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author macbook
 */
public class StackTest {
    @Test
    public void testPush()
    {
        System.out.println("Test case push");
        Stack stack = new Stack();
        stack.push(10);
        assertEquals(1, stack.size());
        int data = stack.pop();
        assertEquals(10,data);
    }
    @Test
    public void testPushTwoElement()
    {
       
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        
        assertEquals(2, stack.size());
         
        int data = stack.pop();
       
        assertEquals(20,data);
        assertEquals(1, stack.size());
    }
}
