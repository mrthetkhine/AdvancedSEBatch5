/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.oop.polymorphism;

/**
 *
 * @author macbook
 */
public class PolyDemo {
    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.draw();
        
        shape = new Rectangle();
        shape.draw();
    }
}
