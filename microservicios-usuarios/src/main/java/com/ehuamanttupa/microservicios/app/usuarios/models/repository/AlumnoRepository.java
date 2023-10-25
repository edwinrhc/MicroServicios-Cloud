package com.ehuamanttupa.microservicios.app.usuarios.models.repository;


import com.ehuamanttupa.microservicios.commons.alumnos.models.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
