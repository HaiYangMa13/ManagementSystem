package com.springcloudt1.managerprovider;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableRabbit
@SpringBootApplication
@EnableEurekaClient
public class ManagerProvider02Application {

	public static void main(String[] args) {
		SpringApplication.run(ManagerProvider02Application.class, args);
	}

}
