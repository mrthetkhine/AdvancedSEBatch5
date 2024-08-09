/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.abstractfactory.swing;

import com.turing.advancedse5.designpattern.abstractfactory.awt.*;
import com.turing.advancedse5.designpattern.abstractfactory.Button;
import com.turing.advancedse5.designpattern.abstractfactory.ComboBox;
import com.turing.advancedse5.designpattern.abstractfactory.Label;
import com.turing.advancedse5.designpattern.abstractfactory.UIAbstractFactory;

/**
 *
 * @author macbook
 */
public class SwingFactory implements UIAbstractFactory{

    @Override
    public Button createButton() {
        return new SwingButton();
    }

    @Override
    public Label createLabel() {
        return new SwingLabel();
    }

    @Override
    public ComboBox createComboBox() {
        return new SwingComboBox();
    }
    
}
