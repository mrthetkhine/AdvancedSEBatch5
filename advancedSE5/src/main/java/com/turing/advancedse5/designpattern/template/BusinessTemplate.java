/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.template;

/**
 *
 * @author macbook
 */
public abstract class BusinessTemplate {
    String fileName;
    BusinessTemplate(String fileName)
    {
        this.fileName =fileName;
    }
    void process()//template method
    {
        this.openFile();
        this.parse();
        this.businessLogic();
    }
    void openFile()
    {
        System.out.println("OpenFile "+this.fileName);
    }
    abstract void parse();
    void businessLogic()
    {
        System.out.println("Business Logic");
    }
            
}
