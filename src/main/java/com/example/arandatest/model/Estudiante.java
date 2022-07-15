package com.example.arandatest.model;
import javax.persistence.*;

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

    public Estudiante() {
    }

    public Estudiante(String nombre, int edad, String ciudad, String zonaHoraria) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.zonaHoraria = zonaHoraria;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
}
