/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.factory;

/**
 *
 * @author macbook
 */
public class ReflectDemo {
    public static void main(String[] args) {
        ConnectionManager manager = new ConnectionManager("Oracle");
        Connection con = manager.createConnection();
        con.open();
    }
}
