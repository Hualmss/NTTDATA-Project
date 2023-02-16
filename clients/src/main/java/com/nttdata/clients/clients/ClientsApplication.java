package com.nttdata.clients.clients;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.nttdata.clients.clients.Service.ClientService;
import com.nttdata.clients.clients.model.Client;

@SpringBootApplication
@EnableEurekaClient
public class ClientsApplication {
	
	@Autowired
	private ClientService clientService;

	public static void main(String[] args) {
		SpringApplication.run(ClientsApplication.class, args);
	}

	@Bean
	CommandLineRunner run() throws ParseException{
		return args -> {
			clientService.saveClinet(new Client(1, "Muebles JOBERT",2,1,"123456"));
			clientService.saveClinet(new Client(2, "Pinturas CPP",2,1,"123456"));
			clientService.saveClinet(new Client(3, "SAMSERG",2,1,"123456"));
			clientService.saveClinet(new Client(4, "Luis Alberto",1,1,"123456"));
			clientService.saveClinet(new Client(5, "Maria Juana",1,1,"123456"));
			clientService.saveClinet(new Client(6, "Jose Miguel",1,1,"123456"));
			
		};
	}

}
