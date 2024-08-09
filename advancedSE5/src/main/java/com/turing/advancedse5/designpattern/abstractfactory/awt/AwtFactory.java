/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.abstractfactory.awt;

import com.turing.advancedse5.designpattern.abstractfactory.Button;
import com.turing.advancedse5.designpattern.abstractfactory.ComboBox;
import com.turing.advancedse5.designpattern.abstractfactory.Label;
import com.turing.advancedse5.designpattern.abstractfactory.UIAbstractFactory;

/**
 *
 * @author macbook
 */
public class AwtFactory implements UIAbstractFactory{

    @Override
    public Button createButton() {
        return new AwtButton();
    }

    @Override
    public Label createLabel() {
        return new AwtLabel();
    }

    @Override
    public ComboBox createComboBox() {
        return new AwtComboBox();
    }
    
}
