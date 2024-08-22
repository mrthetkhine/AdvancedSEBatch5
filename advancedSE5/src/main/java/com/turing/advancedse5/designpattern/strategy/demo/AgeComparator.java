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
public class AgeComparator implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.age-o2.age;
    }
    
}
