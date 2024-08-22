/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.cor;

import java.util.HashMap;

/**
 *
 * @author macbook
 */
public class HttpRequest {
    String url;
    
    HttpRequest(String url)
    {
        this.url = url;
    }
    HashMap<String,String> headers = new HashMap<>();
    
    public void addHeader(String key,String value)
    {
        this.headers.put(key, value);
    }
    String getHeader(String key)
    {
        return this.headers.get(key);
    }
}
