package com.example.arandatest.payload;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class AsignacionInEp implements Serializable {
    private String idExamen;
    private String idEstudiante;
    private String fechaHora;
}
