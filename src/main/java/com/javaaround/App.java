package com.javaaround;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        
       System.out.println( "Hello World!" );
       ArrayList list=new ArrayList();  
       list.add("A");  
       list.add("B");  
       list.add("C");  
        
       for(Object obj:list)  
       System.out.println(obj);   
    }
}
