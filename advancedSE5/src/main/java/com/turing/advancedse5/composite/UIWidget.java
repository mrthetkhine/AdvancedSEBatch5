/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.composite;

/**
 *
 * @author macbook
 */
public abstract class UIWidget {
    String id;
    
    UIWidget(String id)
    {
        this.id = id;
    }
    abstract void draw();
}
