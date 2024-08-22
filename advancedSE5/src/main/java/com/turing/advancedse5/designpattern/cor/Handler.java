/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.turing.advancedse5.designpattern.cor;

/**
 *
 * @author macbook
 */
public interface Handler {
    void handle(HttpRequest request);
    void setNext(Handler handler);
}
