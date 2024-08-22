/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.strategy;

/**
 *
 * @author macbook
 */
public class SortingContext {
    SortingStrategy strategy;

    public SortingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }
    
    void sort()
    {
        this.strategy.sort();
    }
    
}
