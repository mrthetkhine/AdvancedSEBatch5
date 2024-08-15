/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turing.advancedse5.validation;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macbook
 */
public class Validator {
    public static void validate(Object obj)
    {
        Field fields[] = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            //System.out.println("Field "+field);
            NotNull[] notNull = field.getAnnotationsByType(NotNull.class);
            //System.out.println("NotNull "+notNull.length);
            if(notNull.length != 0)
            {
                try {
                    Object value = field.get(obj);
                    if(value == null)
                    {
                        System.err.println("Field "+field.getName()+" is null");
                    }
                } catch (IllegalArgumentException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        Student student = new Student();
        //student.address = "Somewhere";
        
        
        Validator.validate(student);
        
        Human human = new Human();
        Validator.validate(human);
    }
    
}
