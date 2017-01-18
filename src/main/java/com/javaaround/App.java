package com.javaaround;
import java.util.*;  
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[]){  
       
       Set<Currency> currencySet =  EnumSet.range(Currency.USD,Currency.SWISSFRANK);
       for(Currency currency : currencySet)
        System.out.println("currency: " + currency);

    }
}
