/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.cor;

/**
 *
 * @author macbook
 */
public class AuthHandler extends BaseHandler{

    
    @Override
    public void handle(HttpRequest request) {
        System.out.println("Authorized request "+request.url);
        String authorization = request.getHeader("Authorization");
        if(authorization !=null)
        {
            super.handleNext(request);
        }
    }

    
    
}
