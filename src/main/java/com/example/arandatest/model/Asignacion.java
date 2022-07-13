package com.example.arandatest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
