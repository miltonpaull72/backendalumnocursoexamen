package com.formaciobdi.microservicios.app.usuarios1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formaciobdi.microservicios.app.usuarios1.client.CursoFeignClient;
import com.formaciobdi.microservicios.app.usuarios1.models.repository.AlumnoRepository;
import com.formaciobdi.microservicios.commons.services.CommonServiceImpl;
import com.formaciobdi.microservicios.commonsalumnos.models.entity.Alumno;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl <Alumno, AlumnoRepository> implements AlumnoService {

	@Autowired
	private CursoFeignClient clientCurso;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}

	@Override
	public void eliminarCursoAlumnoPorId(Long id) {
		clientCurso.eliminarCursoAlumnoPorId(id);		
	}

	@Override
	@Transactional   //por que liminamos por id
	public void deleteById(Long id) {
		super.deleteById(id);
		this.eliminarCursoAlumnoPorId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		return repository.findAllByOrderByIdAsc();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Alumno> findAll(Pageable pageable) {
		return repository.findAllByOrderByIdAsc(pageable);
	}

	
}
