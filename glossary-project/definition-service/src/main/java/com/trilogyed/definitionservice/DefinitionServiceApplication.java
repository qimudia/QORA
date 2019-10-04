package com.trilogyed.definitionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class DefinitionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DefinitionServiceApplication.class, args);
	}

}
