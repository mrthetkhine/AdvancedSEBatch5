/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turing.advancedse5.designpattern.statemachine;

/**
 *
 * @author Mr T.Khine
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        StateContext context = new StateContext(new HungryState());
        context.doAction();
        context.doAction();
        context.doAction();
    }
}
