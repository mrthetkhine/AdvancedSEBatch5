/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.cor;

/**
 *
 * @author macbook
 */
public abstract class BaseHandler implements Handler{
    Handler next;
    
    public void handleNext(HttpRequest request)
    {
        if(next !=null )
        {
            this.next.handle(request);
        }
    }
    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }
}
