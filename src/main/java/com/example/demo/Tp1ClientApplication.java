package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.consumer.ProduitConsumer;

@SpringBootApplication
public class Tp1ClientApplication {
	
	// because rest template != bean (not under spring control)
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	public static void main(String[] args) {
		
		//instance of spring container
		//DI use design pattern singleton
		//authorConsumer = Bean Controller || RestController || Service...
		//@AutoWired auto cnx 
		//Main class ref
		ApplicationContext context = SpringApplication.run(Tp1ClientApplication.class, args);

		//ProduitConsumer authorConsumer = (ProduitConsumer) context.getBean("produitConsumer");
		
	}

}
