package com.sp.main.service_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer				// ENABLE EUREKA SERVER
public class ServiceRegistryApplication {

	//	SERVICE REGISTRY MAKES SERVICES DISCOVERABLE TO OTHER SERVICES.

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryApplication.class, args);
	}

}
