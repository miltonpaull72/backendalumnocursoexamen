package com.formaciobdi.microservicios.app.examenes.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formaciobdi.microservicios.app.examenes.models.repository.AsignaturaRepository;
import com.formaciobdi.microservicios.app.examenes.models.repository.ExamenRepository;
import com.formaciobdi.microservicios.commons.services.CommonServiceImpl;
import com.formaciobdi.microservicios.commonsexamenes.models.entity.Asignatura;
import com.formaciobdi.microservicios.commonsexamenes.models.entity.Examen;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Examen> findByNombre(String term) {
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly=true)
	public Iterable <Asignatura> findAllAsignatura() {
		return  asignaturaRepository.findAll();
	}

}
