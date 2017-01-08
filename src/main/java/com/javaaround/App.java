package com.javaaround;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
       System.out.println( "Hello World!" );
        
       Integer[] intArray = { 1, 2, 3, 4, 5 };
       Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
       Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

       System.out.println("Array integerArray contains:");
       Operation.printArray(intArray);   // pass an Integer array

       System.out.println("\nArray doubleArray contains:");
       Operation.printArray(doubleArray);   // pass a Double array

       System.out.println("\nArray characterArray contains:");
       Operation.printArray(charArray);   // pass a Character array
    }
}
