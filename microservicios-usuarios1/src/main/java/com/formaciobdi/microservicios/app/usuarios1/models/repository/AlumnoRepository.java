package com.formaciobdi.microservicios.app.usuarios1.models.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.formaciobdi.microservicios.commonsalumnos.models.entity.Alumno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno, Long> {
	@Query("select a from Alumno a where upper(a.nombre) like upper(concat('%',?1,'%')) or a.apellido like upper(concat('%',?1,'%'))")
	public List<Alumno> findByNombreOrApellido(String term);
	
	public Iterable<Alumno> findAllByOrderByIdAsc();
	
	public Page<Alumno> findAllByOrderByIdAsc(Pageable pageable);
}
