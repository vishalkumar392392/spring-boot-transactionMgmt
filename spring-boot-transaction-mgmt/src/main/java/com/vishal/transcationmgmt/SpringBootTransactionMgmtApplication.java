package com.vishal.transcationmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootTransactionMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionMgmtApplication.class, args);
	}

}
