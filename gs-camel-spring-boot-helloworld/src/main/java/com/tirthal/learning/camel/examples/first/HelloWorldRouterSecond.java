package com.tirthal.learning.camel.examples.first;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldRouterSecond {

	@Bean
	RoutesBuilder buildHelloWorldRouter() {
		return new RouteBuilder() {

			// Example -  From direct:helloWorldChannel end-point, route to
			// (i) first log body of message (ii) then add header in message as part of some processing (iii) finally log message body along with headers of Exchange   
			
			@Override
			public void configure() throws Exception {
				log.info("-------------------------------------------> Configuring Second Apache Camel Hello World Router");
				
				from("direct:helloWorldChannel")
				.routeId("hw-ex1-second-router-direct-process-log") // Optionally assign logical router id
				.log("${body}")
				.process("helloWorldProcessor") // For attaching custom message processor - http://camel.apache.org/processor.html
				.to("log:hello.world.out?showHeaders=true"); // Came log component - http://camel.apache.org/log.html
			}
		};
	}
}