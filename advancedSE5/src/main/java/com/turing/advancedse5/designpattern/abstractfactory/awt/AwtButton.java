/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.abstractfactory.awt;

import com.turing.advancedse5.designpattern.abstractfactory.Button;

/**
 *
 * @author macbook
 */
public class AwtButton extends Button{

    @Override
    public void draw() {
        System.out.println("Awt Button draw");
    }
    
  
}
