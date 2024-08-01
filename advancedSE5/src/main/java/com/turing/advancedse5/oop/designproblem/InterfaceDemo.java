/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.oop.designproblem;

/**
 *
 * @author macbook
 */
public class InterfaceDemo {
    public static void main(String[]args)
    {
        Flyable f = new Aeroplane();
        f.fly();
        
        f = new Bird();
        f.fly();
        
        Bird b= new Bird();
        b.fly();
     
    }
}
