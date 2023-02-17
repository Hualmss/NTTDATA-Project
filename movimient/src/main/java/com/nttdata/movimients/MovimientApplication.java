package com.nttdata.movimients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing
public class MovimientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovimientApplication.class, args);
	}

}
