package com.tirthal.learning.camel.examples.second;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldJmsRouter extends RouteBuilder {

	//  Example router to parse files, transform them with XQuery, send them to JMS and then write messages from the queue to a directory
	
	@Override
	public void configure() throws Exception {
		log.info("-------------------------------------------> Configuring Apache Camel Hello World JMS Router");			
		
		// Parse files, transform them with XQuery and send them to JMS
		from("file:src/data?noop=true")
		.routeId("hw-ex2-jms-router-file-log-xquery-jms")
		.log("**************** Transforming input file '${header.CamelFileName}'")
		.to("xquery:helloWorld.xquery")
		.to("jms:queue:HelloWorldQueue");
		
		// Write messages from the queue to a directory
		from("jms:queue:HelloWorldQueue")
		.routeId("hw-ex2-jms-router-jms-log-file")
		.log("**************** Writing output file '${header.CamelFileName}'")
		.to("file:target/outputFiles");
	}
}
