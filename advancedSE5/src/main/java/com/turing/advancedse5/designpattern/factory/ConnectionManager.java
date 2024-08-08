/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.factory;

import com.turing.advancedse5.designpattern.factory.oracle.OracleConnection;
import com.turing.advancedse5.designpattern.factory.mysql.MySQLConnection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macbook
 */
public class ConnectionManager extends ConnectionFactory{
    
    HashMap<String,Class> map ;
    
    String db;
    ConnectionManager(String db)
    {
        this.map =new HashMap<>();
        this.map.put("MySQL",MySQLConnection.class);
        this.map.put("Oracle",OracleConnection.class);
        this.db = db;
    }
    
    @Override
    public Connection createConnection(){
        try {
            Class clazz = this.map.get(this.db);
            Connection con = (Connection) clazz.newInstance();
            return con;
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
