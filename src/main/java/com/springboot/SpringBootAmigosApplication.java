package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootAmigosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmigosApplication.class, args);
	}

}
