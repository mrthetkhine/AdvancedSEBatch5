/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.template;

/**
 *
 * @author macbook
 */
public class CSVTemplate extends BusinessTemplate{
    CSVTemplate(String fileName)
    {
        super(fileName);
    }

    @Override
    void parse() {
        System.out.println("Parse CSV "+this.fileName);
    }
    
}
