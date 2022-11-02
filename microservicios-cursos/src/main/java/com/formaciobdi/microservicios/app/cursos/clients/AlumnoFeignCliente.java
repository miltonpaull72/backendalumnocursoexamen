package com.formaciobdi.microservicios.app.cursos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formaciobdi.microservicios.commonsalumnos.models.entity.Alumno;

@FeignClient(name = "microservicios-usuarios1")
public interface AlumnoFeignCliente {

	@GetMapping("/alumnos-por-curso")
	public Iterable<Alumno> obtenerAlumnosPorCurso(@RequestParam Iterable<Long> ids);
}
