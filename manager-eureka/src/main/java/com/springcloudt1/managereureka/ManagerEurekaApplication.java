package com.springcloudt1.managereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ManagerEurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ManagerEurekaApplication.class, args);
	}

}
