/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern;

import java.awt.Toolkit;

/**
 *
 * @author macbook
 */
public class SingletonDemo {
    public static void main(String[] args) {
        App app1 = App.getInstance();
        App app2 = App.getInstance();
        
        System.out.println("App 1== App2 "+(app1==app2));
        
        //Runtime.getRuntime();
        //Toolkit.getDefaultToolkit();
    }
}
