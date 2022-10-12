package com.example.InvestorRelationBackend;


import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvestorRelationBackendApplication {

	public static void main(String[] args) {
		System.out.println(welcome());
		SpringApplication.run(InvestorRelationBackendApplication.class, args);
		
	}
	public static long welcome() {
		Date nowDate = new Date();
		return nowDate.getTime();
	}

}
