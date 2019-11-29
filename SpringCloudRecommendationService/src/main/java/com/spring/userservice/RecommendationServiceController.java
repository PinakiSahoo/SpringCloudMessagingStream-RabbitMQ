package com.spring.userservice;



import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RecommendationServiceController {

	@RequestMapping(value="/recommendations", method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="recommendationFallback")
	public List<Product> recommendations(){
		List<Product> products=new ArrayList<Product>();
		products.add(new Product("Lenovo","Corei3","link1"));
		products.add(new Product("Acer","Corei3","link2"));
		products.add(new Product("Dell","Corei5","link3"));
		return products;
		
	}
		public List<Product> recommendationFallback(){
			System.out.println("Recommendation Fallback");
			return new ArrayList<Product>();
		}
		
	
}
