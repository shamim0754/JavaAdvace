package com.javaaround;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void drawShapes(List<? extends Shape> lists){  
      for(Shape s:lists){  
          s.draw();
      }  
    }  
    public static void main( String[] args )
    {
        
       System.out.println( "Hello World!" );
       List<Rectangle> list1=new ArrayList<Rectangle>();  
       list1.add(new Rectangle());
       drawShapes(list1);    
    }
}
