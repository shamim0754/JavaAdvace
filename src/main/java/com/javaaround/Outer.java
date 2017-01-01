
package com.javaaround;

public class Outer {

    public class Inner{
        public void print() {
            System.out.println("This is an inner class");
        }
    }

    //access in outer
    void display_inner() {
      Inner inner = new Inner();
      inner.print();
    }  
}