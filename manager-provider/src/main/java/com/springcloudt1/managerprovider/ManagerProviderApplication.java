package com.springcloudt1.managerprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManagerProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerProviderApplication.class, args);
	}

}
