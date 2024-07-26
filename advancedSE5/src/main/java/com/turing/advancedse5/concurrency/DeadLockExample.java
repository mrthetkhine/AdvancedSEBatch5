/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macbook
 */
class Data
{
    int  count = 0;
}
class IncThread extends Thread
{
    Data data;
    Semaphore sem;
    IncThread(Data data,Semaphore sem)
    {
        this.data = data;
        this.sem = sem;
    }
    public void run()
    {
        
        for (int i = 0; i < 100000; i++) {
            try {
                this.sem.acquire();
                data.count++;
                this.sem.release();
                
               
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
    }
}
public class DeadLockExample {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        Data data = new Data();
        
        IncThread t1 = new IncThread(data,sem);
        IncThread t2 = new IncThread(data,sem);
        IncThread t3 = new IncThread(data,sem);
        
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
