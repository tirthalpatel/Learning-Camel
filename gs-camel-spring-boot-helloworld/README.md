# Hello World of Apache Camel using Spring Boot

## Prerequisite

- Java 1.8+
- Maven
- Spring STS IDE (Optional, but recommended)
	
## How to setup this project in STS?

* Import -> Maven -> Existing Maven Projects -> Choose project's root folder and Import.

* Fix JRE configuration issues, if any. Project -> Properties -> Ensure following is configured for Java 1.8
	- Java Build Path -> Libraries -> JRE System Library
	- Java Compiler -> Compiler compliance level = 1.8 
		
## How to run the application and manage/monitor camel processing?

* Run "App.java" as Spring Boot or Java application in STS / Run "mvn spring-boot:run" maven command on command prompt. See console logs.

* Open a lightweight web console for app monitoring in browser [http://localhost:8080/hawtio/index.html](http://localhost:8080/hawtio/index.html])

## Following steps were performed to create this hello world project

* Maven pom.xml - Added Spring Boot, Camel and Hawtio dependencies

* Implemented App.java as starting point of App

* com.tirthal.learning.camel.examples package - Implemented sample code snippet.

## Speaking Snapshot

![HelloWorldJmsRouter example's explanation snapshot](https://github.com/tirthalpatel/Learning-Camel/blob/master/gs-camel-spring-boot-helloworld/snapshots/apache-camel-hawtio-demo.png)
