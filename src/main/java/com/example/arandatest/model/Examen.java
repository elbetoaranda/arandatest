package com.example.arandatest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "examenes")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo_examen", nullable = false)
    private String codigoExamen;

    @Column(name = "nombre_examen", nullable = false)
    private String nombreExamen;

    @Column(name = "zona_horaria", nullable = false)
    private String zonaHoraria;

    @Column(name = "activa", columnDefinition = "boolean default true")
    private boolean activa = true;

    @OneToMany (mappedBy = "examen", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Pregunta> preguntas;

    public Examen() {
    }

    public Examen(String codigoExamen, String nombreExamen, String zonaHoraria, Set<Pregunta> preguntas) {
        this.codigoExamen = codigoExamen;
        this.nombreExamen = nombreExamen;
        this.zonaHoraria = zonaHoraria;
        this.preguntas = preguntas;
    }

    public long getId() {
        return id;
    }

    public String getCodigoExamen() {
        return codigoExamen;
    }

    public void setCodigoExamen(String codigoExamen) {
        this.codigoExamen = codigoExamen;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
