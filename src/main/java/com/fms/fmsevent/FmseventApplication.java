package com.fms.fmsevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableFeignClients("com.fms.fmsevent.Service")
@EnableDiscoveryClient
public class FmseventApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmseventApplication.class, args);
	}

}
