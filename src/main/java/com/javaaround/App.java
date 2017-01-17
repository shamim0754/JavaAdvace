package com.javaaround;
import java.util.*;  
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[]){  
       
       Set<Currency> currencySet =  EnumSet.of(Currency.USD,Currency.EURO);
       for(Currency currency : currencySet)
        System.out.println("currency: " + currency);

    }
}
