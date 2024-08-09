/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turing.advancedse5.designpattern.prototype;

/**
 *
 * @author Mr T.Khine
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        HeavyObject compObj = new HeavyObject();
        HeavyObject another = compObj.reproduce();
        
        System.out.println(another);
        
    }
}
