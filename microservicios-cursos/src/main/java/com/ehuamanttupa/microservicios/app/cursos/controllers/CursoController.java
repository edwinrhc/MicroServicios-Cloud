package com.ehuamanttupa.microservicios.app.cursos.controllers;


import com.ehuamanttupa.microservicios.app.cursos.models.entity.Curso;
import com.ehuamanttupa.microservicios.app.cursos.services.CursoService;
import com.ehuamanttupa.microservicios.commons.alumnos.models.entity.Alumno;
import com.ehuamanttupa.microservicios.commons.controllers.CommonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Curso curs, @PathVariable Long id){

        Optional<Curso>  o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Curso cursoBD = o.get();
        cursoBD.setNombre(cursoBD.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBD));
    }

    @PutMapping("/{id}/asignar-alumnos")
    public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id){
        Optional<Curso>  o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();

        }
        Curso cursoBD = o.get();
        alumnos.forEach(a -> {
            cursoBD.addAlumno(a);
        });
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBD));
    }

    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eliminarAlumnos(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Curso>  o = service.findById(id);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Curso cursoBD = o.get();
        cursoBD.removeAlumno(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBD));
    }



}
