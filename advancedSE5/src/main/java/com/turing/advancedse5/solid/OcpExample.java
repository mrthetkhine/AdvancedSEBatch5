/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.solid;

/**
 *
 * @author macbook
 */
public class OcpExample {
    public static void main(String[] args) {
        
        Engine engine = new ElectricEngine();
        Car car = new Car(engine);
        
        car.start();
    }
}
