package com.springcloudt1.managereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ManagerEureka2Application {
	public static void main(String[] args) {
		SpringApplication.run(ManagerEureka2Application.class, args);
	}

}
