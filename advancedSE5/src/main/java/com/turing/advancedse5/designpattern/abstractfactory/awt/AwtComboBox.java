/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.abstractfactory.awt;

import com.turing.advancedse5.designpattern.abstractfactory.ComboBox;

/**
 *
 * @author macbook
 */
public class AwtComboBox extends ComboBox{
    
    @Override
    public void draw()
    {
        System.out.println("AwtCombo box");
    }
}
