package com.tirthal.learning.camel.examples.first;

import java.time.LocalTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("helloWorldProcessor")
public class HelloWorldProcessor implements Processor {
	public void process(Exchange exchange) throws Exception {		  
	       exchange.getIn().setHeader("Hello-World-Header", "H"+ LocalTime.now().getNano());
	}
}
