/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.bridge.decorator;

/**
 *
 * @author macbook
 */
public class BasicLogger implements Logger{

    @Override
    public String log(String message) {
        return message;
    }
    
}
