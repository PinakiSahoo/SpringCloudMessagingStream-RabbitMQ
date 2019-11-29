package com.spring.userservice;

import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;


@EnableBinding(ProductSource.class)


public class Publisher {
    
	Random r =new Random();//define the speed of the driver
	
	@Bean
//    public Details productDetails() {
//    return new Details() ;
//    }
    @InboundChannelAdapter(channel="ProductDetails",poller= @Poller (fixedDelay="2000"))
	public MessageSource<Details> sendProductDetails() {
		//return "{name:\"lenovo\",description:\"core i5\",detailslink:\"fast charger\"}"; 
		return () -> MessageBuilder.withPayload(new Details("50","45","4521")).setHeader("speed", r.nextInt(8)*10).build();

	}

	class Details{
		public String productId;
		public String customerCode;
		public String productMrp;
		public Details() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Details(String productId, String customerCode, String productMrp) {
			super();
			this.productId = productId;
			this.customerCode = customerCode;
			this.productMrp = productMrp;
		}
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public String getCustomerCode() {
			return customerCode;
		}
		public void setCustomerCode(String customerCode) {
			this.customerCode = customerCode;
		}
		public String getProductMrp() {
			return productMrp;
		}
		public void setProductMrp(String productMrp) {
			this.productMrp = productMrp;
		}
		



	}
}
