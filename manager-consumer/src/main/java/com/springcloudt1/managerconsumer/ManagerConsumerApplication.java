package com.springcloudt1.managerconsumer;

import com.springcloudt1.managerconsumer.cfgbeans.RibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
@RibbonClient(name ="provider",configuration=RibbonRule.class)
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ManagerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerConsumerApplication.class, args);
	}

}
