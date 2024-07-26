/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.concurrency;

/**
 *
 * @author macbook
 */
public class ThreadDemo extends Thread{
    
    String name;
    ThreadDemo(String name)
    {
        this.name = name;
    }
    public void run()
    {
        for (int i = 0; i <= 100; i++) {
            System.out.println("Thread "+this.name+ " i==> "+i);
        }
    }
    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("One");
        ThreadDemo t2 = new ThreadDemo("Two");
        ThreadDemo t3 = new ThreadDemo("Three");
        
        t1.start();
        t2.start();
        t3.start();
        
        try
        {
            t1.join();
            t2.join();
            t3.join();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
}
