/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.abstractfactory;

import com.turing.advancedse5.designpattern.abstractfactory.awt.AwtFactory;
import com.turing.advancedse5.designpattern.abstractfactory.swing.SwingFactory;

/**
 *
 * @author macbook
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        UIAbstractFactory factory = new AwtFactory();
        Button button = factory.createButton();
        Label label = factory.createLabel();
        ComboBox combo = factory.createComboBox();
        
        button.draw();
        label.draw();
        combo.draw();
    }
}
