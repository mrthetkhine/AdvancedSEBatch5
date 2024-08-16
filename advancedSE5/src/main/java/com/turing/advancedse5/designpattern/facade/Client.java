/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.facade;

/**
 *
 * @author macbook
 */
class Computer
{
    Cpu cpu = new Cpu();
    Memory memory = new Memory();
    HardDisk hd = new HardDisk();
    void start()
    {
        hd.load();
        memory.loadRAM();
        cpu.execute();
    }
}
public class Client {
    public static void main(String[] args) {
        
        Computer computer = new Computer();
        computer.start();
       
    }
}
