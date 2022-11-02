package com.formaciobdi.microservicios.app.examenes.services;

import java.util.List;

import com.formaciobdi.microservicios.commons.services.CommonService;
import com.formaciobdi.microservicios.commonsexamenes.models.entity.Asignatura;
import com.formaciobdi.microservicios.commonsexamenes.models.entity.Examen;

public interface ExamenService extends CommonService<Examen> {
	public List<Examen> findByNombre(String term);
	
	public Iterable <Asignatura> findAllAsignatura();
}
