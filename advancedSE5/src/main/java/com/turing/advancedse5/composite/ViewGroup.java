/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */
//Composite
public class ViewGroup extends UIWidget{

    List<UIWidget> children = new ArrayList<UIWidget>();
    public ViewGroup(String id) {
        super(id);
    }

    void addChild(UIWidget child)
    {
        this.children.add(child);
    }
    @Override
    void draw() {
        System.out.println("Draw ViewGroup "+id);
        for (UIWidget child : this.children) {
            child.draw();
        }
    }
    
}
