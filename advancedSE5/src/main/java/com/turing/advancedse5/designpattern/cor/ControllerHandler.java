/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.cor;

/**
 *
 * @author macbook
 */
public class ControllerHandler extends BaseHandler{

    @Override
    public void handle(HttpRequest request) {
        System.out.println("Doing controller for "+request.url);
        super.handleNext(request);
    }
    
}
