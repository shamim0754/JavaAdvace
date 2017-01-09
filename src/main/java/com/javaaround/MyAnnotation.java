package com.javaaround;
import java.lang.annotation.*;  
import java.lang.reflect.*;  
  
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
@interface MyAnnotation{  
	int value();  
}  