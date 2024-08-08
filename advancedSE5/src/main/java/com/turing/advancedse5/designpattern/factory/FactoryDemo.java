/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.factory;

import com.turing.advancedse5.designpattern.factory.oracle.OracleFactory;

/**
 *
 * @author macbook
 */
public class FactoryDemo {
    public static void main(String[] args) {
        ConnectionFactory factory = new OracleFactory();
        //factory = new MySQLFactory();
        
        Connection con = factory.createConnection();
        con.open();
        
        
        
    }
}
