package com.formaciobdi.microservicios.app.usuarios1.services;

import java.util.List;



import com.formaciobdi.microservicios.commons.services.CommonService;
import com.formaciobdi.microservicios.commonsalumnos.models.entity.Alumno;


public interface AlumnoService extends CommonService <Alumno>{

	public List<Alumno> findByNombreOrApellido(String term);
	
	public Iterable<Alumno> findAllById(Iterable<Long> ids);
	
	public void eliminarCursoAlumnoPorId(Long id);
	
}
