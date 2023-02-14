package com.nttdata.products.products;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.nttdata.products.products.model.BankAccount;
import com.nttdata.products.products.model.BankAccountType;
import com.nttdata.products.products.service.BankAccountService;
import com.nttdata.products.products.service.BankAccountTypeService;

@EnableFeignClients
@SpringBootApplication
public class ProductsApplication {

	@Autowired
	private BankAccountTypeService bankAccountTypeService;
	@Autowired
	private BankAccountService bankAccountService;
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


			bankAccountService.saveEnterpriceBankAccount(new BankAccount(1,200,1,1));
			bankAccountService.saveEnterpriceBankAccount(new BankAccount(2,300,2,2));
			bankAccountService.saveEnterpriceBankAccount(new BankAccount(3,400,3,3));
			bankAccountService.savePersonalBankAccount(new BankAccount(4,500,1,4));
			bankAccountService.savePersonalBankAccount(new BankAccount(5,600,2,5));
			bankAccountService.savePersonalBankAccount(new BankAccount(6,700,3,6));
			
		};
		
	}

}
