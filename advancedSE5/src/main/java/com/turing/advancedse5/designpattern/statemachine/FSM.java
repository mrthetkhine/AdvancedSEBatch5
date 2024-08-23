/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.designpattern.statemachine;

/**
 *
 * @author macbook
 */
//0*1**
public class FSM {
    static final int INIT_STATE = 0;
    static final int ZERO_STATE = 1;
    static final int ONE_STATE = 2;
    static final int ERROR_STATE = 3;
    
    
   
    static boolean runState(String data)
    {
        int currentState = INIT_STATE;
        for(int i=0;i<data.length();i++)
        {
            char ch = data.charAt(i);
            
            switch( currentState )
            {
                case INIT_STATE:
                    if(ch== '0')
                    {
                        currentState = ZERO_STATE;
                    }
                    else if(ch=='1')
                    {
                        currentState = ONE_STATE;
                    }
                    else
                    {
                        currentState = ERROR_STATE;
                    }

                        break;
                case ZERO_STATE:
                    if(ch== '0')
                    {
                        currentState = ZERO_STATE;
                    }
                    else if(ch=='1')
                    {
                        currentState = ONE_STATE;
                    }
                    else
                    {
                        currentState = ERROR_STATE;
                    }
                    break;
                case ONE_STATE:
                    if(ch== '0')
                    {
                        currentState = ERROR_STATE;
                    }
                    else if(ch=='1')
                    {
                        currentState = ONE_STATE;
                    }
                    else
                    {
                        currentState = ERROR_STATE;
                    }
            }
        }
        return currentState!= ERROR_STATE ;
    }
    
    public static void main(String[] args) {
        FSM fsm = new FSM();
        
        System.out.println("00001 "+ FSM.runState("0001"));
        System.out.println("111 "+ FSM.runState("111"));
        System.out.println("000 "+ FSM.runState("000"));
        System.out.println("000010 "+ FSM.runState("00010"));
    }
}
