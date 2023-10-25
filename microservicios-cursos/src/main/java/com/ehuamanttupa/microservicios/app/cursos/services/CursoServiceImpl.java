package com.ehuamanttupa.microservicios.app.cursos.services;

import com.ehuamanttupa.microservicios.app.cursos.models.entity.Curso;
import com.ehuamanttupa.microservicios.app.cursos.models.repository.CursoRepository;
import com.ehuamanttupa.microservicios.commons.services.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {
}
