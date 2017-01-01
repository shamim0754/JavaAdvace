
package com.javaaround;

public class Outer {
    static int data=30;
    static class Inner{
        public void print() {
            System.out.println("static inner class" + data);
        }
    }

}