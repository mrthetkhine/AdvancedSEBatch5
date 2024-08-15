/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.bridge.decorator;

import java.util.Date;

/**
 *
 * @author macbook
 */
public class TimeDecorator implements Logger{

    Logger logger;
    TimeDecorator(Logger logger)
    {
        this.logger = logger;
    }
    @Override
    public String log(String message) {
        return (new Date()+" ")+logger.log(message);
    }
    
}
