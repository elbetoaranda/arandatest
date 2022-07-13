package com.example.arandatest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "respuestas")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Asignacion asignacion;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Pregunta pregunta;

    @Column(name="respuesta", nullable = false, length = 1)
    private String respuesta;

    @Column(name = "correcta", columnDefinition = "boolean default false")
    private boolean correcta = false;

    @Column(name = "activa", columnDefinition = "boolean default true")
    private boolean activa = true;
}
