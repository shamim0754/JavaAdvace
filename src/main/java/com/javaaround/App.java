package com.javaaround;
import java.util.*;  
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String args[]){  
        LocalDateTime localDate = LocalDateTime.parse("2016-08-16"+" 12:10:56",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDate);
    }    
}
