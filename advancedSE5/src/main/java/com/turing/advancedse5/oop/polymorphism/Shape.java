/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.oop.polymorphism;

/**
 *
 * @author macbook
 */
abstract public class Shape {
    void init()
    {
        System.out.println("Init");
    }
    abstract void draw();
    void algorithm()
    {
        draw();
    }
   
}
