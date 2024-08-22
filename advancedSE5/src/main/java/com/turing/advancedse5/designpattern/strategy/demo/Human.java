/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.strategy.demo;

import java.util.Comparator;

/**
 *
 * @author macbook
 */
public class Human{
    String name;
    int age;
    Human(String name,int age)
    {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", age=" + age + '}';
    }

}
