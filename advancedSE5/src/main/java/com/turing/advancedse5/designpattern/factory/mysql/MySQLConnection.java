/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.factory.mysql;

import com.turing.advancedse5.designpattern.factory.Connection;

/**
 *
 * @author macbook
 */
public class MySQLConnection implements Connection{

    @Override
    public void open() {
        System.out.println("MySQL Connection opened");
    }
    
}
