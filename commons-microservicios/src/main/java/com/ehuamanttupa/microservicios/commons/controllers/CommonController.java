package com.ehuamanttupa.microservicios.commons.controllers;

import com.ehuamanttupa.microservicios.commons.services.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


public class CommonController<E, S extends CommonService<E>> {

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
    public ResponseEntity<?> crear(@RequestBody E entity){
        E entityDB = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityDB);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> eliminar(@PathVariable(name="id")Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
