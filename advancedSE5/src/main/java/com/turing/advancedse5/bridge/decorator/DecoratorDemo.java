/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.bridge.decorator;

/**
 *
 * @author macbook
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Logger logger = new BasicLogger();
        
        Logger decorator = new HtmlDecorator(new TimeDecorator(logger));
        decorator = new TimeDecorator(logger);
        System.out.println(decorator.log("log message"));
    }
}
