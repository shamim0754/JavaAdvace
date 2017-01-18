package com.javaaround;
import java.util.*;  
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[]){  
       
     EnumMap<Currency, String> map = new EnumMap<Currency, String>(Currency.class);  
     map.put(Currency.USD, "1");  
     map.put(Currency.EURO, "2");  
     map.put(Currency.SWISSFRANK, "3");  
     map.put(Currency.TAKA, "4");  
     // print the map  
     for(Map.Entry m:map.entrySet()) 
         System.out.println(m.getKey()+" "+m.getValue());    
    }
}
