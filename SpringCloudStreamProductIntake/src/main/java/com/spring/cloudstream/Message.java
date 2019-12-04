package com.spring.cloudstream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
@Configuration
@Component
//@EnableBinding(Sink.class)
@EnableBinding(Processor.class)
public class Message {
	
	@StreamListener(target=Sink.INPUT, condition="headers['speed']>40")
	//@ServiceActivator(inputChannel=Sink.INPUT)
	//@StreamListener(Processor.INPUT)
	//@SendTo(Processor.OUTPUT)
	public void logfast(String msg) {
		System.out.println("fast-" +msg);
		
		
	}

	@StreamListener(target=Sink.INPUT, condition="headers['speed']<=40")
	//@ServiceActivator(inputChannel=Sink.INPUT)
	//@StreamListener(Processor.INPUT)
	//@SendTo(Processor.OUTPUT)
	public void logslow(String msg) {
		System.out.println("slow-" +msg);
		
		
	}
}
