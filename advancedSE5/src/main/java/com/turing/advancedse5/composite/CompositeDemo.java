/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.composite;

/**
 *
 * @author macbook
 */
public class CompositeDemo {
    public static void main(String[] args) {
        ViewGroup main = new ViewGroup("Main composite");
        View view1 = new View("Child 1");
        
        main.addChild(view1);
        ViewGroup subView = new ViewGroup("Sub view composite");
        
        subView.addChild(new View("level1 child"));
        subView.addChild(new View("level2 child"));
        
        main.addChild(subView);
        
        main.draw();
    }
}
