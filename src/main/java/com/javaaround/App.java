package com.javaaround;
import java.util.*;  
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[]){  
      
     Integer int1 = 2;  
     Integer int2 = 1;
     // from int2 to int1 = 1(always) since int1 > int2
     int count =  int1.compareTo(int2); 
     System.out.println(count);
     if(count == 1)
       System.out.println(int2 + " then " + int1);
     else if (count == -1)
       System.out.println(int1 + " then " + int2);
     else
       System.out.println(int1 + "equal" + int2);
  
    }
}
