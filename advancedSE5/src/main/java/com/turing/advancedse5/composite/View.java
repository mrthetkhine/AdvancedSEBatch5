/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.composite;

/**
 *
 * @author macbook
 */
public class View extends UIWidget{

    public View(String id)
    {
        super(id);
    }
    @Override
    void draw() {
        System.out.println("Draw View "+this.id);
    }
    
}
