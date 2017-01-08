package com.javaaround;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    } 
    public static void main( String[] args )
    {
        
       System.out.println( "Hello World!" );
      List<Integer> li = Arrays.asList(1, 2, 3);
      List<String>  ls = Arrays.asList("one", "two", "three");
      printList(li);   
    }
}
