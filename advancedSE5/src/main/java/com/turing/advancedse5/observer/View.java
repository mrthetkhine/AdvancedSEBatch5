/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.observer;

/**
 *
 * @author macbook
 */
public class View implements Subscriber{

    String name;
    View(String name)
    {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println("Vie "+this.name+ "update with message "+message);
    }
    
}
