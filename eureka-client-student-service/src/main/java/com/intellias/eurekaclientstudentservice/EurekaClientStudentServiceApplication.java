package com.intellias.eurekaclientstudentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientStudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientStudentServiceApplication.class, args);
	}

}
