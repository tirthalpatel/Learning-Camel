package com.tirthal.learning.camel.examples.first;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloWorldBean")
public class HelloWorldBean {

	// Inform Spring Boot to assign value from application.properties file
    @Value("${first.router.greeting.msg}")
    private String msg;

    public String sayHello() {    	
    	return msg + LocalDateTime.now();
    }

}