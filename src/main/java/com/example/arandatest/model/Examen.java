package com.example.arandatest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
