package com.example.arandatest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "zona_horaria", nullable = false)
    private String zonaHoraria;

    @Column(name = "activa", columnDefinition = "boolean default true")
    private boolean activa = true;
}
