package com.nttdata.products.products;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nttdata.products.products.model.BankAccountType;
import com.nttdata.products.products.service.BankAccountTypeService;

@SpringBootApplication
public class ProductsApplication {

	@Autowired
	BankAccountTypeService bankAccountTypeService;
	public static void main(String[] args) {
		SpringApplication.run(ProductsApplication.class, args);
		//comentartio
	}


	@Bean
	CommandLineRunner run() throws ParseException{
		return args -> {
			bankAccountTypeService.saveBankAccountType(new BankAccountType(1,"Cuenta ahorro", 5,5));
			bankAccountTypeService.saveBankAccountType(new BankAccountType(2,"Cuenta corriente", 5,5));
			bankAccountTypeService.saveBankAccountType(new BankAccountType(3,"Cuenta a plazo fijo", 5,5));
			
		};
		
	}

}
