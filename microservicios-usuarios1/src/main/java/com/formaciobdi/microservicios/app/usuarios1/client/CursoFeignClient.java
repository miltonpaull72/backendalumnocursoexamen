package com.formaciobdi.microservicios.app.usuarios1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="microservicios-cursos")
public interface CursoFeignClient {

	@DeleteMapping("/eliminar-alumno/{id}")
	public void eliminarCursoAlumnoPorId(@PathVariable Long id);
}
