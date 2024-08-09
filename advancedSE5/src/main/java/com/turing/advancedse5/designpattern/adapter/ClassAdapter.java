/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.adapter;

/**
 *
 * @author macbook
 */
public class ClassAdapter extends OldApi implements NewApi{

    @Override
    public void add(int item) {
        super.push(item);
    }
    
    public static void main(String[] args) {
        NewApi api = new ClassAdapter();
        api.add(100);
    }
}
