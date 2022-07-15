package com.example.arandatest.payload;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@ToString
public class RespuestaInEp implements Serializable {

    private String idPregunta;
    private String respuesta;
}
