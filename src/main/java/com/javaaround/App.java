package com.javaaround;
import java.util.*;  
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[]){  
      
     Student s1 = new Student(101,"shamim",23);  
     Student s2 = new Student(102,"alamin",28); 
    
     int count =  s1.compareTo(s2); 
     System.out.println(count);
     if(count > 1)
       System.out.println(s2.name + "->" + s1.name);
     else if (count < 1)
       System.out.println(s1.name + "->" + s2.name);
     else
       System.out.println(s1.name + "=" + s2.name);
  
    }
}
