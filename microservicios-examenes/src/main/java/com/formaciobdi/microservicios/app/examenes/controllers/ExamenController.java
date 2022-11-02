package com.formaciobdi.microservicios.app.examenes.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formaciobdi.microservicios.app.examenes.services.ExamenService;
import com.formaciobdi.microservicios.commons.controllers.CommonController;
import com.formaciobdi.microservicios.commonsexamenes.models.entity.Examen;
import com.formaciobdi.microservicios.commonsexamenes.models.entity.Pregunta;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService>{
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Examen examen,BindingResult result, @PathVariable Long id ){

		if (result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Examen> o = service.findById(id);
		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Examen examenDb=o.get();
		examenDb.setNombre(examen.getNombre());
		List<Pregunta> eliminadas = new ArrayList<>();
		examenDb.getPreguntas().forEach(pdb -> {
			if (!examen.getPreguntas().contains(pdb)) {
				eliminadas.add(pdb);
			}
		});
		
		
		/*examenDb.getPreguntas()
		.stream()
		.filter(pdb -> !examen.getPreguntas().contains(pdb))
		.forEach(examenDb::removePregunta);	*/
		
		
		eliminadas.forEach(p -> {
			examenDb.removePregunta(p);
		});

		/*eliminadas.forEach(examenDb::eliminarPregunta);*/
		
	    examenDb.setPreguntas(examen.getPreguntas());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDb));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByNombre(term));
	}
	
	@GetMapping("/asignaturas")
	public ResponseEntity<?> listarAsignatura(){
		return ResponseEntity.ok(service.findAllAsignatura());
	}
}
