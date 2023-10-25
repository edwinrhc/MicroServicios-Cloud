package com.ehuamanttupa.microservicios.commons.alumnos.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    //Creamos un metodo en la fecha
    @PrePersist
    public void prePersist(){
        this.createAt = new Date();
    }


    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof  Alumno)){
            return false;
        }
        Alumno a = (Alumno) obj;
        return this.id != null && this.id.equals(a.getId());
    }

}
