package com.javaaround;
public class Box<T extends Number> {
    private T t;

    public void set(T t) { 
        this.t = t; 
    }
    public T get() { 
        return t; 
    }
}