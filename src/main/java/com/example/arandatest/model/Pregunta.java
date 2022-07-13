package com.example.arandatest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen", nullable = false)
    private Examen examen;

    @Column(name="codigo_pregunta", nullable = false)
    private String codigoPregunta;

    @Column(name="texto_pregunta", nullable = false)
    private String textoPregunta;

    @Column(name="opcion_a", nullable = false)
    private String opcionA;

    @Column(name="opcion_b", nullable = false)
    private String opcionB;

    @Column(name="opcion_c", nullable = false)
    private String opcionC;

    @Column(name="opcion_d", nullable = false)
    private String opcionD;

    @Column(name="valor", nullable = false)
    private Integer valor;

    @Column(name="correcta", nullable = false, length = 1)
    private String correcta;

    @Column(name = "activa", columnDefinition = "boolean default true")
    private boolean activa = true;

}
