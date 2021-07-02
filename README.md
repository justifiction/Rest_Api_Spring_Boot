# Rest Api with Spring Boot

This is a small Spring-Boot Rest Api with Swagger.

It allows to add or delete a word to/from a collection, to get the number of word's occurances and to get a list of unique words. 
It is also possible to see the entire collection (words and number of occurnaces) and to delete all the elements.

Swagger was used for Rest Api documentation and for easier manual testing.

<h2> Requirements </h2>

Java 13

Maven 3 

Spring Boot 2.5.2

Swagger 3.0.0

<h2> How to build and run </h2>

You can import the code straight into your preferred IDE or run the sample using the following commands (in the root project folder).

<b>mvn clean package

$  mvn spring-boot:run</b>

or

<b>java -jar ./target/springbootdemo-1.0.0-SNAPSHOT.jar </b>

<h2> Using the API </h2>

Simply start the app here http://localhost:8080/swagger-ui/ and test HTTP requests by using Swagger funcionality. 

<h2> To test the application in the IDE </h2>

By running class <b>ControllerTests</b> you will run Unit Tests

src/main/java/pl.justifiction.springbootdemo/tests/ControllerTests