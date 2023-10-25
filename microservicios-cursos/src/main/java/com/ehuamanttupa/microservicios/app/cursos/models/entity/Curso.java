package com.ehuamanttupa.microservicios.app.cursos.models.entity;

import com.ehuamanttupa.microservicios.commons.alumnos.models.entity.Alumno;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name ="cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nombre;

    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Alumno> alumnos;


    @PrePersist
    public void prePersist(){
        this.createAt = new Date();
    }

    public Curso(Long id) {
       this.alumnos  = new ArrayList<>();
    }

    public void addAlumno(Alumno alumno){
        this.alumnos.add(alumno);
    }

    public void removeAlumno(Alumno alumno){
        this.alumnos.remove(alumno);
    }




}
