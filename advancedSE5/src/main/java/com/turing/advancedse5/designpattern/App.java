/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern;

/**
 *
 * @author macbook
 */
public class App {
    private static App singleton;
    
    private App()
    {
    }
    public static App getInstance()
    {
        if(singleton==null)
        {
            singleton = new App();
        }
        return singleton;
    }
    
}
