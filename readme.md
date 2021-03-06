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

1. If a class is usefull to only one class, it makes sense to keep it nested and together.
2. It increases encapsulation.inner classes can access outer class private members and at the same time we can hide inner class from outer world.

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

### static nested class ###
A static class i.e. created inside a class is called static nested class in java. since it is static it can only access static thing

```java

package com.javaaround;

public class Outer {
    static int data=30;
    static class Inner{
        public void print() {
            System.out.println("static inner class" + data);
        }
    }

}
```
App.java

```java
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Outer.Inner inner = new Outer.Inner();
        inner.print();
    }
}
```
### Inner Class ###
Inner classes are class within Class,Unlike a class, an inner class can be private,protected since it is  treated like member of the outer class

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
Outer.class
Inner$Outer.class
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

###  Method Local Inner Class ###
When an inner class is defined inside the method of Outer Class it becomes Method local inner class.

Method local inner class can be only instantiated within the method 

```java

package com.javaaround;

public class Outer {
    int count=10;
    public void display(){
        class Inner {        
            public void show(){
             System.out.println("Inside inner "+count);
            } 
       }

       Inner in=new Inner();
       in.show();
    }
}
```
App.java

```java
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
        
        Outer outer = new Outer();
        outer.display();
    }
}

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

### Nested Interface ###
```java
package com.javaaround;
interface Showable{  
  void show();  
  interface Message{  
   void msg();  
  }  
}    
```  
or

```java
package com.javaaround;
class Showable{  
  void show();  
  interface Message{  
   void msg();  
  }  
} 
```
or

```java
interface Showable{  
  class Message{  
   void msg();  
  }  
} 
```

update App.java

```java
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

```

In collection frameword, sun microsystem has provided a nested interface Entry. Entry is the subinterface of Map i.e. accessed by Map.Entry.


### Generics  Benefits ###

1. Generics add stability to your code by making more of your bugs detectable at compile time.Without generic bugs are arise at runtime that more problematic to fixing.
2. Elimination of casts
```java
List<String> list = new ArrayList<String>();
list.add("hello");
//String s = (String)list.get(0); //without generic need cast
String s = list.get(0); // no cast
```
3. Enabling programmers to implement generic algorithms.

### Before Generics ###
```java
package com.javaaround;
public class Box {
    private Object object;

    public void set(Object object) { 
        this.object = object; 
    }
    public Object get() { 
        return object; 
    }
}
```
any object can pass but using generics you can inforce to specific type

update App.java

```java
Box box = new Box();
box.set(new Integer(10)); 
Integer s = (Integer)box.get();
System.out.println(s);
```

compile the class

`mvn clean compile`

### Using Generics ###
A class that can refer to any type is known as generic class.  generic class is delimited by angle brackets (<>), follows the class name.  Here, we are using T `type parameter` to create the generic class of specific type. Generics introduced in at java 5


```java
package com.javaaround;
public class Box<T> {
    private T t;

    public void set(T t) { 
        this.t = t; 
    }
    public T get() { 
        return t; 
    }
}
```

Now compile time error happens if type mismatch
```java
Box box<Integer> = new Box<Integer>();
box.set("shamim"); //compile time error
System.out.println(box.get());
```

compile the class

`mvn clean compile`

need to pass param only Integer

```java
Box<Integer> box = new Box<Integer>();
box.set(new Integer(12)); //no error now
System.out.println(box.get());
```        
compile the class

`mvn clean compile`

### Bounded Type ###
`Box<T extends Number>`

### Type Parameters naming conventions ###
The type parameters naming conventions are important to learn generics thoroughly. The commonly type parameters are as follows:

1. T - Type
2. E - Element
3. K - Key
4. N - Number
5. V - Value
6. S,U,V etc. - 2nd, 3rd, 4th types

### Apply Generics ###
In java, collections framework allow to write now generics style code.

Before generics
```java
List list = new ArrayList();  
list.add("hello");  
String s = (String) list.get(0);//typecasting  
```

After generics
```java

List<String> list = new ArrayList<String>();  
list.add("hello");  
String s = list.get(0);  

```

### Java 7 Type Inference ### 

From Java 7 the Java compiler can infer the type of the collection instantiated from the variable the collection is assigned to

 `List<String> strings = new ArrayList<>();`

 Notice that generic type of the ArrayList has been left out. Instead is only the <> written. This is also sometimes referred to as the `diamond operator`


### Generic Method ### 

 Like generic class, we can create generic method that can accept any type of argument.

 ```java
package com.javaaround;
public class Operation{  
  
   public static < E > void printArray(E[] elements) {  
        for ( E element : elements){          
            System.out.println(element );  
         }  
         System.out.println();  
    }  
}  
 ```

Update App.jva

 ```java
   Integer[] intArray = { 1, 2, 3, 4, 5 };
   Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
   Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

   System.out.println("Array integerArray contains:");
   Operation.printArray(intArray);   // pass an Integer array

   System.out.println("\nArray doubleArray contains:");
   Operation.printArray(doubleArray);   // pass a Double array

   System.out.println("\nArray characterArray contains:");
   Operation.printArray(charArray);   // pass a Character array
 ```

### Bounded Type Parameters ###

Requirements : counts the number of elements in an array T[] that are greater than a specified element elem.

```java
public static <T> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray)
        if (e > elem)  // compiler error
            ++count;
    return count;
}
```
it does not compile because the greater than operator (>) applies only to primitive types such as short, int, double, long, float, byte, and char.

To fix the problem, use a type parameter bounded by the Comparable<T> interface:

```java
public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
    int count = 0;
    for (T e : anArray)
        if (e.compareTo(elem) > 0)
            ++count;
    return count;
}
```
### Upper Bounded Wildcard  ###

 The ? (Question Mark) symbol represents wildcard element. It means any type. If we write <? extends Number>, it means any child class of Number e.g. Integer, Float, double etc

 Shape.java
 ```java
package com.javaaround;

import java.util.*;  
abstract class Shape{  
    abstract void draw();  
}  
 ```

 Rectangle.java
 ```java
package com.javaaround;
class Rectangle extends Shape{  
    void draw(){
        System.out.println("drawing rectangle");
    }  
} 
 ```

 Update App.java

 ```java
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

 ```
### Lower Bounded Wildcard  ###
To write the method that works on lists of Integer and the supertypes of Integer, such as Integer, Number, and Object, you would specify List<? super Integer>.

```java
public static void addNumbers(List<? super Integer> list) {
    for (int i = 1; i <= 10; i++) {
        list.add(i);
    }
}
```
### UnBounded Wildcard  ###

Update App.java

```java
public class App 
{
    public static void printList(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    } 
    public static void main( String[] args )
    {
        
       System.out.println( "Hello World!" );
      List<Integer> li = Arrays.asList(1, 2, 3);
      List<String>  ls = Arrays.asList("one", "two", "three");
      printList(li);   
      printList(ls);   
    }
}

```

### Annotation  ###

1. Used to associate metadata(some extra info) into source code which can be used by java compiler and JVM.
2. Introduce to java 5
3. Simple to use compare to metadata using xml 

### Built-In Java Annotations ###
1. @Override
2. @SuppressWarnings
3. @Deprecated
4. @Target
5. @Retention
6. @Inherited
7. @Documented
7. @toString

###  @Override ###
@Override annotation assures that the subclass method is overriding the parent class method. If it is not so, compile time error occurs.

###  @SuppressWarnings ###
is used to suppress(remove) warnings issued by the compiler.

Update App.java

```java
 ArrayList list=new ArrayList();  
 list.add("A");  
 list.add("B");  
 list.add("C");  
  
 for(Object obj:list)  
 System.out.println(obj);
```
compile the class

`mvn clean compile`

gives `uses unchecked or unsafe operations.` warning because it use non generic collection

For removing this type of warning @SuppressWarnings is used

Now. App.java
```java
@SuppressWarnings("unchecked")
public static void main( String[] args )

```

compile the class again

`mvn clean compile`

Now warning has been gone

### @Deprecated ###

@Deprecated annoation marks that this method is deprecated so compiler prints warning. It informs user that it may be removed in the future versions. So, it is better not to use such methods.

```java
package com.javaaround;
class A{  
  @Deprecated  
  void n(){
    System.out.println("hello n");
  }  
}  
```

Update App.java
```java
A a=new A();  
a.n();  
```
compile the class 

`mvn clean compile`

givs Note: Test.java uses or overrides a deprecated API. warning

### Example Junit ###

![Image of Nested](images/annotation.png)

### Example EJB ###

![Image of Nested](images/annotation1.png)

### Custom Annotation ###

```java
<modifier> @interface <annotation-name>{
  //body
}
```

There are three types of annotations.

1. Marker Annotation : has no method e.g @Override and @Deprecated
2. Single-Value Annotation : has one method
3. Multi-Value Annotation :  more one method

### Allow annotation types ###
1. Primitive types(int , double etc)
2. java.lang.String
3. java.lang.Class
4. Enum
5. Another annotation type
6. Array of above types String[],int[]

Example | Usage
-------------- | -------------
String skils[]    | skils{"java","php"} ,if one value skils="php"
Class provider()   | provider=Someprovider.class
Remark remark()     |
public enum Remarks{ | remark = Remark.GOOD
  "GOOD","BAD"        |
}                     |


1. create MyAnnotation.java
```java
package com.javaaround;
import java.lang.annotation.*;  
import java.lang.reflect.*;  
  
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
@interface MyAnnotation{  
  int value(); 
  //use default keyword if you provide value
  String value2() default "xyz";   
}  
```

@Target is used to specify at which level, the annotation is allow other can't use it.

ElementType | Allow
----------------- | -------------
ElementType.METHOD  | Only allow methods level used
ElementType.FIELD  | Only allow field level used
ElementType.TYPE  | Only allow class,interface,enum level used
ElementType.CONSTRUCTOR  | Only allow CONSTRUCTOR level used
ElementType.LOCAL_VARIABLE  | Only allow LOCAL_VARIABLE level used
ElementType.ANNOTATION_TYPE  | Only allow ANNOTATION_TYPE level used
ElementType.PARAMETER  | Only allow PARAMETER level used

you can use multiple value 

`@TargetElementType.METHOD,ElementType.FIELD)`

@Retention is used to specify to what level annotation will be available

RetentionPolicy | Availability
----------------- | -------------
RetentionPolicy.SOURCE | refers to the source code, discarded during compilation
RetentionPolicy.CLASS | available to java compiler but not to JVM
RetentionPolicy.RUNTIME | available to java compiler and JVM

1. Usage of MyAnnotaton
```java
package com.javaaround;

class Hello{  
  //@MyAnnotation(value=10,value1="shamim")
  @MyAnnotation(value=10)  
  public void sayHello(){
    System.out.println("hello annotation");
  }  
}
```
2. Access of MyAnnotaton

update App.java

```java
try{ 
  Hello h=new Hello();  
  Method m=h.getClass().getMethod("sayHello");  
    
  MyAnnotation manno=m.getAnnotation(MyAnnotation.class);  
  System.out.println("value is: "+manno.value()+ "," +manno.value1());
}catch(Exception e){
  
}    
```

OR Access all annotation of method

```java
try{ 
    Class<Hello> c = Hello.class;
    Annotation[] annotations = c.getDeclaredMethod("sayHello").getAnnotations();
    for(Annotation annotation : annotations){
      
      if(annotation instanceof MyAnnotation){
        MyAnnotation manno = (MyAnnotation) annotation;
        System.out.println("value is: "+manno.value() + "," +manno.value1());
      }
    }
  }catch(Exception e){

  }
```

if you need all annotation of class level(Type)
```java
Annotation[] annotations = c.getAnnotations();
```

### @Inherited ###
By default, custom annotations are not inherited to subclasses as a result you can't use it into subclasses.The @Inherited annotation marks the annotation to be inherited to subclasses.

```java
@Inherited 
@interface MyAnnotation{  
  int value();  
}  
```

### @Documented ###

The @Documented Marks the annotation for inclusion in the documentation


### Enum ###
```java
class Employee{
  public String gender;
}
```
Since gender is string field then user can enter any kind of string like "Malee","Fimadd" etc.To prevent any kind of string entry enum is used because enum allow only certain value(MALE,FEMALE).So
Enum  is a special data type that contains fixed set of constants. it was introduced in JDK 1.5 . Enum is a very useful and well known feature



### Defining  enum ###
The enum can be defined within or outside the class because it is similar to a class.

1. Create Currency.java
```java
package com.javaaround;
public enum Currency {
   USD,EURO,SWISSFRANK,TAKA;
}
```
2. Update App.java
```java
package com.javaaround;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main(String args[]){
        //1
        System.out.println(Currency.USD); 
        //2
        System.out.println(Currency.valueOf("USD")); 
        //3 
        for (Currency currency : Currency.values())  
          System.out.println(currency);  

    }
}

```
defined within class

```java
package com.javaaround;

/**
 * Hello world!
 *
 */
public class App 
{
    public enum Currency {
       USD,EURO,SWISSFRANK,TAKA;
    }
    public static void main(String args[]){
        //1
        System.out.println(Currency.USD); 
        //2
        System.out.println(Currency.valueOf("USD")); 
        //3 
        for (Currency currency : Currency.values())  
          System.out.println(currency);  

    }
}

```

### Access Enum ###
There are 3 ways to access enum.

1. direct access using the enum value e.g. Currency.USD
2. access using enum name, e.g. Currency.valueOf("USD")
3. get enumeration of all enum values using values() method, e.g. Currency.values()

### Initializing enum fields ### 

enum fields can be initialize when constants define by param.Through param it call constructor to set field value.

Update currency.java
```java
  USD("$","United Amerial"),EURO("€","England"),SWISSFRANK("₣","Swizerland"),TAKA("৳","Bangladesh");
  private String icon;
  private String country; 
  Currency(String icon, String country){
    this.icon = icon; 
    this.country = country; 
  }
  public String getIcon(){
    return icon;
  }
  public String getCountry(){
    return country;
  }

```

Update App.java
```java
 for (Currency currency : Currency.values())  
    System.out.println("currency name = " + currency 
      + "icon = "+currency.getIcon() 
      + "country = "+currency.getCountry());  

```


### Benefits Enum ###

1. Enum are reference type like class or interface

  ```java
  Currency currency = Currency.USD;

  ```
2. <b>Enum is type-safe</b> you can not assign anything else other than predefined Enum constants to an Enum variable.if assign gives errors

  ```java
  Currency currency = Currency.USD;
  currency = 1; //compile error
  ```
3. Enum can be used at Switch statement like int or char primitive data type.from JDK 7 onwards you can also String in Switch case in Java
  ```java
  Currency currency = Currency.USD;
  switch (currency) { 
    case USD: 
      System.out.println("USD currency"); 
      break; 
    case EURO: 
      System.out.println("EURO currency"); 
      break; 
    case SWISSFRANK: 
      System.out.println("SWISSFRANK currency"); 
      break; 
    case TAKA: 
      System.out.println("TAKA currency"); 
  }

  ```
3. Adding new constants on Enum in Java is easy and you can add new constants without breaking the existing code

### Points to remember ###
1. Enum may implement many interfaces but cannot extend any class because it internally extends `java.lang.Enum` class

  ```java
  public enum Currency implements Runnable{
    //code 
    @Override 
    public void run() { 
      System.out.println("Enum in Java implement interfaces"); 
    }

  }
  ```
2. Since compiler internally create class so it can have fields, constructors and methods

  ```java
  public enum Operation {
      PLUS,
      MINUS,
      TIMES,
      DIVIDE;

      double calculate(double x, double y) {
          switch (this) {
              case PLUS:
                  return x + y;
              case MINUS:
                  return x - y;
              case TIMES:
                  return x * y;
              case DIVIDE:
                  return x / y;
              default:
                  throw new AssertionError("Unknown operations " + this);
          }
      }

  }
  ```
Access
  ```java
  double result = Operation.PLUS.calculate(1, 2);
  System.out.println(result); //3.0
  ```
3. Constructor of enum type is private. If you don't declare private compiler internally creates private constructor.

4. you can't create instance of enum by new keyword because it contains private constructors

5. Enum constants are implicitly `static and final` and can not be changed once created(cannot be reassigned)
  ```javav
  Currency.USD = Currency.EURO; // compilation error
  ```
6.  The compiler automatically adds some special methods when it creates an enum like
  1.  `values()` : The values() method returns an array containing all the values of the enum
  2. `valueOf` : Convert a String to Enum object
  3. `name()` : returns the exact string which is used to create that particular Enum constant
  4. `ordinal()` : eturns the position of a Enum constant as they declared in enum

7. compare enum using `"=="` or `Java.lang.Enum.equals() ` or `Java.lang.Enum.compareTo()`

  ```java
  Currency usCurrency = Currency.USD; 
  if(usCurrency == Currency.USD){ 
    System.out.println("enum in java can be compared using =="); 
  }

  /*
  //recommended approvch
  if(usCurrency.equals(Currency.USD)){ 
    System.out.println("enum in java can be compared using equals"); 
  }
  */
  ```
8. The semicolon at the end of an enum declaration is optional.
  ```java
   public enum Days {  
      Monday, Tuesday, Wednesday, Thursday  
   };
   //or
   /*
   public enum Days {  
      Monday, Tuesday, Wednesday, Thursday  
   }
   */
  ```
9.  Enum can override methods 
  ```java
  public enum Currency {

    @Override
    public String toString() {
      switch (this) { 
      case USD: 
        System.out.println("USD currency"); 
        break; 
      case EURO: 
        System.out.println("EURO currency"); 
        break; 
      case SWISSFRANK: 
        System.out.println("SWISSFRANK currency"); 
        break; 
      case TAKA: 
        System.out.println("TAKA currency"); 
      }
    }
  }
  ```
10. You can define abstract methods inside Enum

  ```java
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
  ```

Access
  ```java
  System.out.println("Color: " + Currency.USD.color());
  ```
11. Two collection classes  are added into collection package to support Java Enum
  1. EnumSet

    ```java
    //get some value 
    Set<Currency> currencySet =  EnumSet.of(Currency.USD,Currency.EURO);
    //get all value
    Set<Currency> currencySet =  EnumSet.allOf(Currency.class);
    //get range value
    Set<Currency> currencySet =  EnumSet.range(Currency.USD,Currency.TAKA);

    //get empty set
    Set<Currency> currencySet =  EnumSet.noneOf(Currency.class);
    //get as a list
    List<Currency> currencyList =  new ArrayList<Currency>(EnumSet.allOf(Currency.class));
    ```
  2. EnumMap : EnumMap class is the specialized Map implementation for use enum as keys.

    ```java
    EnumMap<Currency, String> map = new EnumMap<Currency, String>(Currency.class);  
     map.put(Currency.USD, "1");  
     map.put(Currency.EURO, "2");  
     map.put(Currency.SWISSFRANK, "3");  
     map.put(Currency.TAKA, "4");  
     // print the map  
     for(Map.Entry m:map.entrySet()) 
         System.out.println(m.getKey()+" "+m.getValue());
    ```

### Sort Object ###
We can sort the elements of:

1. String objects
2. Wrapper class objects
3. User-defined class objects

For sort above object we need to implement `java.util.Comparable` interface.java.util.Comparable syntax
```java
public interface Comparable{
  public int compareTo(Object obj);
}
```

### Sort String & Wrapper ###
String class and Wrapper classes implements Comparable interface by default.

![Image of Nested](images/ascii.png)

1. String class : Java String classes overide compareTo method such a way that return difference of first mismatch character ascii value.it either 0,>0,< 0 .String Object `compareTo` method override by java api programmer

    ```java
    public int compareTo(String anotherString) {
        int len1 = value.length;
        int len2 = anotherString.value.length;
        int lim = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = anotherString.value;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }
    ```

    ```java
    String s1 = "shamim";  
    String s2 = "alamin"; 
    // difference s2 to s1 (112-97) = 18 
    int count =  s1.compareTo(s2); 
    System.out.println(count);
    if(count > 1)
     System.out.println(s2 + " then " + s1);
    else if (count < 1)
     System.out.println(s1 + " then " + s2);
    else
     System.out.println(s1 + " equal " + s2);

    ```

    Replace s1 by s1


    ```java
     String s1 = "alamin";  
     String s2 = "shamim"; 
     // difference s2 to s1 (97-112) = -18 
     int count =  s1.compareTo(s2); 
     System.out.println(count);
     if(count > 1)
       System.out.println(s2 + " then " + s1);
     else if (count < 1)
       System.out.println(s1 + "then" + s2);
     else
       System.out.println(s1 + "equal" + s2);

    ```

Note : since uppercase and lowercase ascii value different so it is not equal to compare .for such case you use

```java
String s1 = "alamin".toLowerCase();  
String s2 = "Shamim".toLowerCase(); 
```

2. Wrapper classes : Java Wrapper classes overide compareTo method such a way that return either 0, 1 or -1.
Integer Object `compareTo` method override by java api programmer

   ```java

    public int compareTo(Integer anotherInteger) {

        return compare(this.value, anotherInteger.value);
    }
    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

   ```

   ```java
   Integer int1 = 1;  
   Integer int2 = 2;
   // from int2 to int1 = -1(always) since int2 > int1
   int count =  int1.compareTo(int2); 
   System.out.println(count);
   if(count == 1)
     System.out.println(int2 + " then " + int1);
   else if (count == -1)
     System.out.println(int1 + " then " + int2);
   else
     System.out.println(int1 + "equal" + int2);
   ```

   Replace int1 by int2

   ```java
   Integer int1 = 2;  
   Integer int2 = 1;
   // from int2 to int1 = 1(always) since int1 > int2
   int count =  int1.compareTo(int2); 
   System.out.println(count);
   if(count == 1)
     System.out.println(int2 + " then " + int1);
   else if (count == -1)
     System.out.println(int1 + " then " + int2);
   else
     System.out.println(int1 + "equal" + int2);
   ```

### Sort User-define Object ###
User-define object must be implements override `compareTo` method such a way that return either 0, 1 or -1(Wrapper class) or 0,>0,< 0(String)

User define String property sort

1. Create Student.java

```java
package com.javaaround;
import java.util.*;  
class Student implements Comparable<Student>{  
  int rollno;  
  String name;  
  int age;  
  Student(int rollno,String name,int age){  
    this.rollno=rollno;  
    this.name=name;  
    this.age=age;  
  }  
  
  public int compareTo(Student student){  
    return name.compareTo(student.name);
  }  
}  
```

App.java

```java
 Student s1 = new Student(101,"shamim",23);  
 Student s2 = new Student(102,"alamin",28); 

 int count =  s1.compareTo(s2); 
 System.out.println(count);
 if(count > 1)
   System.out.println(s2.name + "->" + s1.name);
 else if (count < 1)
   System.out.println(s1.name + "->" + s2.name);
 else
   System.out.println(s1.name + "=" + s2.name);
```

User define Wrapper property sort

Update Student.java

```java
public int compareTo(Student student){  
    if(age == student.age)  
      return 0;  
    else if(age > student.age)  
      return 1;  
    else  
      return -1;  
     
}  
```

### Comparator interface ###

`Comparable` interface allow to sort one property at a time as a result if you want to sort using other property  you need to update `Student.java` also.it is so much dependent Student.java

To overcome such problem java introduce `Comparator` interface . by Comparator you need not to change existing code

java.util.Comparator syntax
```java
public interface Comparator{
  public int compare(Object obj1,Object obj2)
}
```

1. create AgeComparator.java


```java
package com.javaaround;
import java.util.*;  
class AgeComparator implements Comparator{   
  
  public int compare(Object o1,Object o2){
    Student s1=(Student)o1;  
    Student s2=(Student)o2;    
    if(s1.age == s2.age)  
      return 0;  
    else if(s1.age > s2.age)  
      return 1;  
    else  
      return -1;  

  }  
}  
```

2. Update App.java
```java
Student s1 = new Student(101,"shamim",23);  
Student s2 = new Student(102,"alamin",28); 

int count =  new AgeComparator().compare(s1,s2); 
System.out.println(count);
if(count > 1)
 System.out.println(s2.name + "->" + s1.name);
else if (count < 1)
 System.out.println(s1.name + "->" + s2.name);
else
 System.out.println(s1.name + "=" + s2.name);
```

### Sorting in Collection ###

comparable & comparator is generally used in collection

Sort by `comparable interface`

```java
ArrayList<Student> al=new ArrayList();  
al.add(new Student(101,"shamim",23));  
al.add(new Student(102,"alamin",28));  
 
Collections.sort(al);  
 
for(Student student : al)  
  System.out.println(student.rollno+" "+student.name+" "+student.age);

```

Sort by `comparator interface`
 
```java
Collections.sort(al,new AgeComparator());  

```

### equals() & hasCode() ###

`Java.lang.Object` has methods called hasCode() and equals(). These methods play a significant role in the real time application.Every object extends `java.lang.Object`

### equals() method ###

equals() method is used to equal any object!!!!!.e.g String Object

String Object `equals` method override by java api programmer

```java
public boolean equals(Object anObject) {
    //string pool if same reference
    if (this == anObject) {
        return true;
    }
    //check content equals if reference is not same
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

Wrapper Class(e.g Integer)
Integer Object equals override by java api programmer

```java
public boolean equals(Object obj) {
    if (obj instanceof Integer) {
        return value == ((Integer)obj).intValue();
    }
    return false;
}
```

User-define class (Student) equals override by own for correct equal logic.
we can get help of Integer override that is done by java api programmer

Update Student.java

```java
  @Override
  public boolean equals(Object obj) {
      if (obj instanceof Student) {
        Student student = (Student) obj;
          return this.rollno == student.rollno 
                 && this.age == student.age;
      }
      return false;
} 
```

Update App.java
```java
Student s1 = new Student(101,"shamim",23);  
Student s2 = new Student(101,"alamin",28); 
System.out.println("s1 & s2 equal : " + s1.equals(s2));
```

if you decide rollno and age (any logic) equal then those object eqauls.

Update Student.java

```java
 return this.rollno == student.rollno 
        && this.age == student.age;
```

Update App.java
```java
Student s1 = new Student(101,"shamim",23);  
Student s2 = new Student(101,"alamin",23); 
System.out.println("s1 & s2 equal : " + s1.equals(s2));
```


###  hashCode() ###

The `java.lang.Object.hashCode()` method returns a hash code value for the object. This method override is necessary  when using hash based collection(key-value pair) like `java.util.Hashtable`,`java.util.HashMap`,`java.util.HashSet`

String Object `hashCode` method override by java api programmer

```java
public int hashCode() {
   // private final char value[];
    int h = 0;
    if (h == 0 && value.length > 0) {
        char val[] = value;

        for (int i = 0; i < value.length; i++) {
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}
```

Wrapper Class(e.g Integer)
Integer Object hashCode() override by java api programmer

```java
public static int hashCode(int value) {
    return value;
}
```

### How Hashing  works ###

When inserting an object into a hash based structure like `hashtable,HashMap,HashSet` we use key-value pair.First The hash code of this key is calculated(by hashing algorithm).if hash code(bracket,pointing area at structure) found in the strucutre then it replace existing object otherwise it store as a new element

When you need to lookup an object again hash code of this key is calculated if hash code(bracket,pointing area at structure) found in the strucutre then it calls `equals` method of object .if equals then it contains search element

Note : we saw , Hash structure is internally call `equals()` method. so it is necessary to override `equals()` when you override `HashCode()`. So it is suggested to override both methods into your define class


### Problem without eqauls & hashCode ###

if you hashCode() & equals() method in your own classes are not override then Java Collections API(HashSet,HashMap,HashTable) are not to work correctly.

```java
 Student s1 = new Student(101,"shamim",23);  
 Student s2 = new Student(101,"alamin",23); 
 HashSet<Student> hs = new HashSet<Student>();
 hs.add(s1);
 hs.add(s2);
 System.out.println("contains : "+hs.contains(new Student(101,"shamim",23))); 
```
We pass same object but it is not exists;

update Student.java

```java
@Override
  public boolean equals(Object obj) {
      if (obj instanceof Student) {
        Student student = (Student) obj;
          return this.rollno == student.rollno
            && this.age == student.age;
      }
      return false;
  }
  @Override
  public int hashCode(){
    return age;
  }
```

Run again

Now it show it is exists;

