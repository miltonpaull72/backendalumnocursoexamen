package com.formaciobdi.microservicios.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.formaciobdi.microservicios.commonsalumnos.models.entity",
	"com.formaciobdi.microservicios.app.cursos.models.entity",
	"com.formaciobdi.microservicios.commonsexamenes.models.entity"})

public class MicroserviciosCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCursosApplication.class, args);
	}

}
