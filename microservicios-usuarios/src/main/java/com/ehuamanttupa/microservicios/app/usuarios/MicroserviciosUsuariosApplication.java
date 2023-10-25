package com.ehuamanttupa.microservicios.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;




@SpringBootApplication
@EnableDiscoveryClient
@EntityScan({"com.ehuamanttupa.microservicios.commons.alumnos.models.entity"})
public class MicroserviciosUsuariosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosUsuariosApplication.class, args);
    }

}
