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
       Box<Integer> box = new Box<Integer>();
       box.set(new Integer(12)); //no error now
       System.out.println(box.get());
    }
}
