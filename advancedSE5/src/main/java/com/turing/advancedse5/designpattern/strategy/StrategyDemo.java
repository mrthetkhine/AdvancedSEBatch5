/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.strategy;

/**
 *
 * @author macbook
 */
public class StrategyDemo {
    public static void main(String[] args) {
        SortingContext context = new SortingContext();
        
        context.setStrategy(new SelectionSort());
        context.sort();
        
        context.setStrategy(new MergeSort());
        context.sort();
    }
}
