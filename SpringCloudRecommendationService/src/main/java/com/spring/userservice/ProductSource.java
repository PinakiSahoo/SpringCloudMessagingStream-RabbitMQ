package com.spring.userservice;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProductSource {
	
	@Output("ProductDetails")
	MessageChannel productDetails();
	@Output("ProductLink")
	MessageChannel productsLink();
	

}
