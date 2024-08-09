/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.adapter;

/**
 *
 * @author macbook
 */
public class ObjectAdapter implements NewApi{
    OldApi api = new OldApi();

    @Override
    public void add(int item) {
        api.push(item);
    }
    public static void main(String[] args) {
        NewApi newApi = new ObjectAdapter();
        newApi.add(200);
    }
    
}
