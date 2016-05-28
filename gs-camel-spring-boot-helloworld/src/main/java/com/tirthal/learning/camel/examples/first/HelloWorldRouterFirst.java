package com.tirthal.learning.camel.examples.first;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldRouterFirst extends RouteBuilder {	
	
	@Value("${first.router.greeting.msg}")
    private String msg;
	
	// Example - From timer trigger event, then Bean to router hello message to  direct:helloWorldChannel end-point
	
	@Override
	public void configure() {		
		log.info("-------------------------------------------> Configuring First Apache Camel Hello World Router");				
		
		// Deal Letter Channel EIP - http://camel.apache.org/dead-letter-channel.html
		errorHandler(deadLetterChannel("jms:queue:DeadHelloWorldQueue")
				.useOriginalMessage().maximumRedeliveries(3).redeliveryDelay(1000));
		
		// Thanks Spring Boot meets Camel - So "first.router.timer.period" value coming from application.properties
		from("timer:hello?period={{first.router.timer.period}}") // Timer component to generate periodic events every 2 seconds - http://camel.apache.org/timer.html
		.routeId("hw-ex1-first-router-timer-bean-direct") // Optionally assign logical router id
		.bean("helloWorldBean") // Camel's "bean" component to bind beans to Camel message exchanges - http://camel.apache.org/bean.html
        .to("direct:helloWorldChannel");	// Camel supported "direct" component for in-memory messaging via synchronous - http://camel.apache.org/direct.html        
		
		// Camel has several ways to configure the same bean routing, for example, as below		
		// .bean("helloWorldBean", "sayHello")
		// .to("bean:helloWorldBean")
		// .to("bean:helloWorldBean?method=sayHello")		
	}
}