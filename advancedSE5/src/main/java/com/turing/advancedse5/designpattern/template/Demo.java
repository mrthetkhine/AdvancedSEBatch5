/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.template;

/**
 *
 * @author macbook
 */
public class Demo {
    public static void main(String[] args) {
        BusinessTemplate temp = new CSVTemplate("CSVFile");
        temp.process();
        
        temp = new ExcelTemplate("Excel File");
        temp.process();
    }
}
