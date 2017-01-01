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
        // Instantiating the outer class 
        Outer outer = new Outer();
      
        // Accessing the display_Inner() method.
        outer.display_inner();

        Outer.Inner inner = outer.new Inner();
        inner.print();
    }
}
