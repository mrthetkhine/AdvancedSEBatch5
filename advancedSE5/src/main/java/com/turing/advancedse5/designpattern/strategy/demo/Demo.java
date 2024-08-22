/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.strategy.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author macbook
 */
public class Demo {
    public static void main(String[] args) {
        List<Human> humans =new ArrayList<>();
        
        humans.add(new Human("Aung AUng",14));
        humans.add(new Human("Hla Hla",10));
        
        Collections.sort(humans, new AgeComparator());
        
        for(Human h : humans)
        {
            System.out.println(h);
        }
    }
}
