package com.ehuamanttupa.microservicios.commons.controllers;

import com.ehuamanttupa.microservicios.commons.services.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonController<E, S extends CommonService<E>> {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    protected S service;

    @GetMapping
    public ResponseEntity<?> listar(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?>ver(@PathVariable(name = "id") Long id){

        Optional<E> o = service.findById(id);
        if(o.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(o.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody E entity) {
        try {
            E entityDB = service.save(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);
        } catch (Exception e) {
            // Registra la excepción en los registros para su depuración.
            logger.error("Error al crear el registro: {}", e.getMessage(), e);

            // Devuelve una respuesta de error detallada.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el registro: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminar(@PathVariable(name="id")Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
