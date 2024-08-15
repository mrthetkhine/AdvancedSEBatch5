/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.bridge;

/**
 *
 * @author macbook
 */
public class BrdigeDemo {
    public static void main(String[] args) {
        DrawingApi api = new CanvasApi();
        
        Shape shape = new Circle(api);
        shape.draw();
        
        shape = new Rectangle(api);
        shape.draw();
    }
}
