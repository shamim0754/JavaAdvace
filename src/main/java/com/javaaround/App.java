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
     Student s2 = new Student(101,"alamin",23); 
     HashSet<Student> hs = new HashSet<Student>();
     hs.add(s1);
     hs.add(s2);
     System.out.println("contains : "+hs.contains(new Student(101,"shamim",23))); 
    }
}
