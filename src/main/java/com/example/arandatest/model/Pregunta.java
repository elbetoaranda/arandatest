package com.example.arandatest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name = "preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_examen", nullable = false)
    @JsonBackReference
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

    public Pregunta() {
    }

    public Pregunta(Examen examen, String codigoPregunta, String textoPregunta, String opcionA, String opcionB, String opcionC, String opcionD, Integer valor, String correcta) {
        this.examen = examen;
        this.codigoPregunta = codigoPregunta;
        this.textoPregunta = textoPregunta;
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.opcionD = opcionD;
        this.valor = valor;
        this.correcta = correcta;
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

    public String getCodigoPregunta() {
        return codigoPregunta;
    }

    public void setCodigoPregunta(String codigoPregunta) {
        this.codigoPregunta = codigoPregunta;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public String getOpcionA() {
        return opcionA;
    }

    public void setOpcionA(String opcionA) {
        this.opcionA = opcionA;
    }

    public String getOpcionB() {
        return opcionB;
    }

    public void setOpcionB(String opcionB) {
        this.opcionB = opcionB;
    }

    public String getOpcionC() {
        return opcionC;
    }

    public void setOpcionC(String opcionC) {
        this.opcionC = opcionC;
    }

    public String getOpcionD() {
        return opcionD;
    }

    public void setOpcionD(String opcionD) {
        this.opcionD = opcionD;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
