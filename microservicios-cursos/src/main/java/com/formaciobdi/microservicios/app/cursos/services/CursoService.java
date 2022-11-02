package com.formaciobdi.microservicios.app.cursos.services;




import com.formaciobdi.microservicios.app.cursos.models.entity.Curso;
import com.formaciobdi.microservicios.commons.services.CommonService;
import com.formaciobdi.microservicios.commonsalumnos.models.entity.Alumno;

public interface CursoService extends CommonService<Curso> {
	public Curso findCursoByAlumnoId(Long id);
	public Iterable<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);
	public Iterable<Alumno> obtenerAlumnosPorCurso(Iterable<Long> ids);
	public void eliminarCursoAlumnoPorId(Long id);
}
