package com.example.InvestorRelationBackend;


import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.InvestorRelationBackend.configuration.DatabaseName;
//import com.example.InvestorRelationBackend.configuration.Invenstor1Database;
import com.example.InvestorRelationBackend.configuration.InvestorDatabase;

@SpringBootApplication
public class InvestorRelationBackendApplication {

	public static void main(String[] args) {
		System.out.println(welcome());
		SpringApplication.run(InvestorRelationBackendApplication.class, args);
		List<String> tenantList=DatabaseName.getAllTenant();
		System.out.println("welcome");
		for(String tenant :tenantList) {
			String dataBaseName=DatabaseName.dataBaseName(tenant);
			System.out.println(dataBaseName);
			InvestorDatabase.createDataBases(dataBaseName);
			  
		}
		
	}
	public static long welcome() {
		Date nowDate = new Date();
		return nowDate.getTime();
	}

}
