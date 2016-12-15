### Warmup ###
1. create maven java project by following command

	`mvn archetype:generate -DgroupId=com.javaaround -DartifactId=SpringBatch -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false`

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

### Anonymous Class ##	

A class that have no name is known as anonymous class in java.it enable you to declare and instantiate a class at the same time. Before creating anonymous class there must be `parent class` or `interace`.
<br/>
<b>Usecase : </b> Use them if you need to use a local class only once.
