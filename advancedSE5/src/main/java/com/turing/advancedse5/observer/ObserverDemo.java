/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.observer;

/**
 *
 * @author macbook
 */
public class ObserverDemo {
    public static void main(String[] args) {
        Publisher model = new Model();
        Subscriber view1 = new View("View 1");
        Subscriber view2 = new View("View 2");
        Subscriber view3 = new View("View 3");
        
        model.addSubscriber(view1);
        model.addSubscriber(view2);
        model.addSubscriber(view3);
        
        model.notifySubscribers("Update 1");
        model.removeSubscriber(view2);
        model.notifySubscribers("Update 2");
    }
}
