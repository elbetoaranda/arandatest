package com.example.arandatest.payload;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode
@ToString
public class RespuestasOutEP implements Serializable {
    private String idAsignacion;
    private String calificacion;

    private List<RespuestaOutEp> detalles;
}
