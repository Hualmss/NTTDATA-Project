package com.nttdata.movimients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



@SpringBootApplication
@EnableEurekaClient
public class MovimientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovimientApplication.class, args);
	}

}
