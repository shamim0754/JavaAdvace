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
        /*try{ 
          Hello h=new Hello();  
          Method m=h.getClass().getMethod("sayHello");  
            
          MyAnnotation manno=m.getAnnotation(MyAnnotation.class);  
          System.out.println("value is: "+manno.value());
        }catch(Exception e){

        }  */
        try{ 
          Class<Hello> c = Hello.class;
          Annotation[] annotations = c.getDeclaredMethod("sayHello").getAnnotations();
          for(Annotation annotation : annotations){
            System.out.println(annotation);
            if(annotation instanceof MyAnnotation){
              MyAnnotation manno = (MyAnnotation) annotation;
              System.out.println("value is: "+manno.value());
            }
          }
        }catch(Exception e){

        }

    }
}
