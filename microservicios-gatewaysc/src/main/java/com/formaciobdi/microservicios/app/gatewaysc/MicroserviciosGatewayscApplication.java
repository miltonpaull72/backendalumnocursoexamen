package com.formaciobdi.microservicios.app.gatewaysc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviciosGatewayscApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosGatewayscApplication.class, args);
	}

}
