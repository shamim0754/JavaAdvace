package com.javaaround;
import java.util.*;
import java.lang.annotation.*;  
import java.lang.reflect.*;  
/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main(String args[]){  
        try{ 
          Hello h=new Hello();  
          Method m=h.getClass().getMethod("sayHello");  
            
          MyAnnotation manno=m.getAnnotation(MyAnnotation.class);  
          System.out.println("value is: "+manno.value());
        }catch(Exception e){
          
        }     
    }
}
