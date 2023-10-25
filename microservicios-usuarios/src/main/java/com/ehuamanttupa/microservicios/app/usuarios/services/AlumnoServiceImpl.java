package com.ehuamanttupa.microservicios.app.usuarios.services;



import com.ehuamanttupa.microservicios.app.usuarios.models.repository.AlumnoRepository;
import com.ehuamanttupa.microservicios.commons.alumnos.models.entity.Alumno;
import com.ehuamanttupa.microservicios.commons.services.CommonServiceImpl;
import org.springframework.stereotype.Service;




// Aquí se extiende con el proyecto de Commons
@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno,AlumnoRepository> implements AlumnoService {


}
