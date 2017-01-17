package com.javaaround;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[]){  
        for (Currency currency : Currency.values())  
          System.out.println("currency name = " + currency 
            + "icon = "+currency.getIcon() + "country = "+currency.getCountry());  

    }
}
