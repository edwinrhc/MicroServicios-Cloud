package com.ehuamanttupa.microservicios.app.usuarios.controllers;

import com.ehuamanttupa.microservicios.app.usuarios.models.entity.Alumno;
import com.ehuamanttupa.microservicios.app.usuarios.services.AlumnoService;
import com.ehuamanttupa.microservicios.commons.controllers.CommonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno,@PathVariable(name="id") Long idAlumno){

        Optional<Alumno>  o = service.findById(idAlumno);
        if(o.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Alumno alumnoDB = o.get();
        alumnoDB.setNombre(alumno.getNombre());
        alumnoDB.setApellido(alumno.getApellido());
        alumnoDB.setEmail(alumno.getEmail());
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoDB));
    }


}
