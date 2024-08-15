/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.bridge;

/**
 *
 * @author macbook
 */
public class Rectangle extends Shape{

    public Rectangle(DrawingApi api)
    {
        super(api);
    }
    @Override
    void draw() {
        api.drawRectangle();
    }
    
}
