package com.example.arandatest.controller;

import com.example.arandatest.exception.ResourceNotFoundException;
import com.example.arandatest.model.Asignacion;
import com.example.arandatest.model.Examen;
import com.example.arandatest.model.Pregunta;
import com.example.arandatest.model.Respuesta;
import com.example.arandatest.payload.RespuestaOutEp;
import com.example.arandatest.payload.RespuestasInEp;
import com.example.arandatest.payload.RespuestasOutEP;
import com.example.arandatest.repository.AsignacionRepository;
import com.example.arandatest.repository.ExamenRepository;
import com.example.arandatest.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/respuestas")
public class RespuestaController {

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;


    @PostMapping
    public RespuestasOutEP validarRespuestas(@RequestBody RespuestasInEp respuestasInEp){
        RespuestasOutEP out = new RespuestasOutEP();

        //TODO se puede validar si la asignacion ya ha sio coontestada y calificada que ya no permita

        //TODO validar dato de entrada no null no empty
        Long idAsignacion = new Long(respuestasInEp.getIdAsignacion());

        Asignacion asignacion = asignacionRepository.findById(idAsignacion)
                .orElseThrow(() -> new ResourceNotFoundException("No existe asignacion con id: "+idAsignacion));

        Examen examen = asignacion.getExamen();

        out.setIdAsignacion(respuestasInEp.getIdAsignacion());

        Set<Pregunta> preguntas = examen.getPreguntas();

        Map<Long, String> respuestasMap = respuestasInEp.getRespuestasMap();

        Integer calificacion = 0;

        List<RespuestaOutEp> respuestaOutEps = new ArrayList<>();
        for(Pregunta pregunta : preguntas){

            String respuestaSeleccionada = (respuestasMap.containsKey(pregunta.getId())) ? respuestasMap.get(pregunta.getId()) : "N";
            String respuestaCorrecta =  pregunta.getCorrecta();

            RespuestaOutEp respuestaOutEp = new RespuestaOutEp();
            respuestaOutEp.setIdPregunta(new Long(pregunta.getId()).toString());
            respuestaOutEp.setRespuestaSeleccionada(respuestaSeleccionada);
            respuestaOutEp.setRespuestaCorrecta(respuestaCorrecta);
            respuestaOutEp.setValor(pregunta.getValor().toString());

            Respuesta respuesta = new Respuesta();
            respuesta.setAsignacion(asignacion);
            respuesta.setPregunta(pregunta);
            respuesta.setRespuesta(respuestaSeleccionada);

            if(respuestaSeleccionada.equals(respuestaCorrecta)){
                respuesta.setCorrecta(true);
                calificacion = calificacion + pregunta.getValor();
                respuestaOutEp.setResultado("CORRECTA");
            }else{
                respuestaOutEp.setResultado("INCORRECTA");
            }

            respuestaRepository.save(respuesta);
            respuestaOutEps.add(respuestaOutEp);
        }

        asignacion.setCalificacion(calificacion);
        asignacion.setContestada(true);
        asignacionRepository.save(asignacion);

        out.setCalificacion(calificacion.toString());
        out.setDetalles(respuestaOutEps);

        return out;
    }

}
