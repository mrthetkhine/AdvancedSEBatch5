/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.cor;

import java.util.Date;

/**
 *
 * @author macbook
 */
public class LogHandler extends BaseHandler{

    @Override
    public void handle(HttpRequest request) {
        System.out.println("Log request "+new Date()+" "+ request.url);
        super.handleNext(request);
    }
    
}
