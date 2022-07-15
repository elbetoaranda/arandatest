package com.example.arandatest.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Examen examen;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Estudiante estudiante;

    @Column(name = "horario_examen")
    private ZonedDateTime horarioExamen;

    @Column(name = "horario_estudiante")
    private ZonedDateTime horarioEstudiante;

    @Column(name = "activa", columnDefinition = "boolean default true")
    private boolean activa = true;

    @Column(name = "contestada", columnDefinition = "boolean default false")
    private boolean contestada = false;

    @Column(name = "calificacion")
    private Integer calificacion;

    public Asignacion() {
    }

    public Asignacion(Examen examen, Estudiante estudiante, ZonedDateTime horarioExamen, ZonedDateTime horarioEstudiante) {
        this.examen = examen;
        this.estudiante = estudiante;
        this.horarioExamen = horarioExamen;
        this.horarioEstudiante = horarioEstudiante;
    }

    public long getId() {
        return id;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public ZonedDateTime getHorarioExamen() {
        return horarioExamen;
    }

    public void setHorarioExamen(ZonedDateTime horarioExamen) {
        this.horarioExamen = horarioExamen;
    }

    public ZonedDateTime getHorarioEstudiante() {
        return horarioEstudiante;
    }

    public void setHorarioEstudiante(ZonedDateTime horarioEstudiante) {
        this.horarioEstudiante = horarioEstudiante;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public boolean isContestada() {
        return contestada;
    }

    public void setContestada(boolean contestada) {
        this.contestada = contestada;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
}
