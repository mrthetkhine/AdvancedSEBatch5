/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.factory.mysql;

import com.turing.advancedse5.designpattern.factory.Connection;
import com.turing.advancedse5.designpattern.factory.ConnectionFactory;

/**
 *
 * @author macbook
 */
public class MySQLFactory extends ConnectionFactory{

    @Override
    public Connection createConnection() {
        return new MySQLConnection();
    }
    
}
