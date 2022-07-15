package com.example.arandatest.payload;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode
@ToString
public class RespuestasInEp implements Serializable {

    private String idAsignacion;

    private List<RespuestaInEp> respuestas;

    public Map getRespuestasMap(){
        HashMap<Long, String> respuestasMap = new HashMap<Long, String>();

        for(RespuestaInEp r : respuestas){
            respuestasMap.put(new Long(r.getIdPregunta()), r.getRespuesta());
        }

        return respuestasMap;
    }
}
