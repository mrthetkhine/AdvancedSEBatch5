/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.cor;

/**
 *
 * @author macbook
 */
public class CorDemo {
    public static void main(String[] args) {
        HttpRequest request = new HttpRequest("http://localhost:8080/api/something");
        request.addHeader("Authorization", "Bearear token");
        Handler loggerHandler = new LogHandler();
        Handler authHandler = new AuthHandler();
        Handler controller = new ControllerHandler();
        
        loggerHandler.setNext(authHandler);
        authHandler.setNext(controller);
        
        loggerHandler.handle(request);
    }
}
