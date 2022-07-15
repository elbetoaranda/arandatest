package com.example.arandatest.model;

import javax.persistence.*;

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

    public Respuesta() {
    }

    public Respuesta(Asignacion asignacion, Pregunta pregunta, String respuesta, boolean correcta) {
        this.asignacion = asignacion;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.correcta = correcta;
    }

    public long getId() {
        return id;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
