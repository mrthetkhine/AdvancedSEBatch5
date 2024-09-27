/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.tdd.advancedse5;

/**
 *
 * @author macbook
 */
public class Stack {
   
    int items[]= new int[SIZE];
    static final int SIZE = 10;
    int top =-1;
    public void push(int data)
    {
    	if(top == SIZE-1)
    	{
    		throw new StackOverflowException("Stackoverflow");
    	}
    	else
    	{
    		 this.items[++top]=data;
    	}
       
        
    }
    public int pop()
    {
        return this.items[top--];
    }
    public int size()
    {
        return this.top+1;
    }
}
