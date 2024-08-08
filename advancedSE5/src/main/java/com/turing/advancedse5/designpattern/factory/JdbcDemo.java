/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author macbook
 */
public class JdbcDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc://");
        } catch (SQLException ex) {
            Logger.getLogger(JdbcDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
