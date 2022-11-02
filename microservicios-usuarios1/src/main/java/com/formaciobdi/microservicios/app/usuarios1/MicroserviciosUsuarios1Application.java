package com.formaciobdi.microservicios.app.usuarios1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.formaciobdi.microservicios.commonsalumnos.models.entity"})
public class MicroserviciosUsuarios1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosUsuarios1Application.class, args);
	}

}
