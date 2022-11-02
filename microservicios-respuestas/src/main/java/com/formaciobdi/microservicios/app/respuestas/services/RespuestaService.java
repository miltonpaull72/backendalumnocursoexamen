package com.formaciobdi.microservicios.app.respuestas.services;

import com.formaciobdi.microservicios.app.respuestas.models.entity.Respuesta;

public interface RespuestaService {
	public Iterable<Respuesta>  saveAll(Iterable<Respuesta> respuesta);
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);
	public Iterable<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);
}
