package com.javaaround;

/**
 * Hello world!
 *
 */
public class App implements Showable.Message
{
    public void msg(){
      System.out.println("nested interface");
    }  
    public static void main( String[] args )
    {
        
       System.out.println( "Hello World!" );
        
       Showable.Message message=new App();//upcasting here  
       message.msg();  
    }
}
