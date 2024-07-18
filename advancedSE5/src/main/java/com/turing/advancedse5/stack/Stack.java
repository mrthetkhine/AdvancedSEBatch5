/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.stack;

/**
 *
 * @author macbook
 */
class Stack {
   
    int items[]= new int[SIZE];
    static final int SIZE = 10;
    int top =-1;
    public void push(int data)
    {
        this.items[++top]=data;
        
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
