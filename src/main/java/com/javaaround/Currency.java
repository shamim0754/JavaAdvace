package com.javaaround;
public enum Currency {
  USD(){
    @Override 
    public String color() { 
      return "copper"; 
    }

  },EURO(){
    @Override 
    public String color() { 
      return "silver"; 
    }
  };
  public abstract String color();
}