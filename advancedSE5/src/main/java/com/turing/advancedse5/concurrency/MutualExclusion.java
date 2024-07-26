/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author macbook
 */
class Data
{
    AtomicInteger count = new AtomicInteger(0);
}
class IncThread extends Thread
{
    Data data;
    IncThread(Data data)
    {
        this.data = data;
    }
    public void run()
    {
        
        for (int i = 0; i < 100000; i++) {
            data.count.incrementAndGet();
            
            /*
            synchronized(data)
            {
                data.count++;
            }
            */
            
            /*
            try
            {
                Thread.sleep(1);
            }
            catch(Exception e) 
            {
            }*/
            
        }
    }
}
public class MutualExclusion {
    public static void main(String[] args) {
        Data data = new Data();
        
        IncThread t1 = new IncThread(data);
        IncThread t2 = new IncThread(data);
        IncThread t3 = new IncThread(data);
        
        t1.start();
        t2.start();
        t3.start();
        
        try
        {
            t1.join();
            t2.join();
            t3.join();
            System.out.println("Data "+data.count);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
