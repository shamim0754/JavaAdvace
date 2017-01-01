### Warmup ###
1. create maven java project by following command

	`mvn archetype:generate -DgroupId=com.javaaround -DartifactId=JavaAdvance -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

2. Update AppTest.java
	```java
	package com.javaaround;

	import org.junit.Test;;

	/**
	 * Unit test for simple App.
	 */
	/**
	 * Unit test for simple App.
	 */
	public class AppTest {
	   @Test
	   public void AppTest( ){
	        App.main(null);
	   }
	}
	```

3. Update junit version at pom.xml

	```xml
	<version>4.8.1</version>
	```

4. Run app by following command

	`mvn clean package`

### Nested Class ###

The Java programming language allows you to define a class within another class. Such a class is called a nested class

### Why Use Nested Classes ###

1. It is a way of logically grouping classes that are only used in one place
2. It increases encapsulation
3. It can lead to more readable and maintainable code

### Categories Nested Class ###

![Image of Nested](images/inner_classes.jpg)

```java
class OuterClass {
    ...
    static class StaticNestedClass {
        ...
    }
    class InnerClass {
        ...
    }
}
```
### Inner Class ###
Inner classes are class within Class,Unlike a class, an inner class can be private,protected

```java
package com.javaaround;
public class Outer {
	//if private you can't outside
    public class Inner{
        public void print() {
            System.out.println("This is an inner class");
        }
    }

}
```
If you compile above code it will produce two class file.

```java
outer.class
inner$outer.class
```
Note : We can’t directly execute the inner class’s .class file with java command.

### How to access Inner Class ###
1. Within outer class . update Outer.java

```java
//access in outer
    void display_Inner() {
      Inner inner = new Inner();
      inner.print();
    }  
```
1. Outside outer class . update App.java

```java
System.out.println( "Hello World!" );
// Instantiating the outer class 
Outer outer = new Outer();

// Accessing the display_Inner() method.
outer.display_inner();

Outer.Inner inner = outer.new Inner();
inner.print();
```

### Anonymous Class ###

A class that have no name is known as anonymous class in java.it enable to making an instance of an object with certain "extras" such as overloading methods, without creating to actually subclass a class. Before creating anonymous class there must be `parent class` or `interace`.
<br/>
<b>Usecase : </b> Use them if you need to override the method of a class or an interface only once.

1. Usage in java sewing

	```java
	button.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // do something
	    }
	});
	```
1. create Adder.java

	```java
	package com.javaaround;
	interface Adder{
	   public int add(int num1,int num2);
	}
	```	

2. Update App.java

	```java
	 Adder adder = new Adder(){
        	 public int add(int num1,int num2) {
        	 	return num1 + num2;
        	 }
        };
    System.out.println( "sum=" + adder.add(2,3));
	```	

3. Run app 

	`mvn clean package`	
