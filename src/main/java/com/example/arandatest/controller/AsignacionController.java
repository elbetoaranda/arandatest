package com.example.arandatest.controller;

import com.example.arandatest.exception.ResourceNotFoundException;
import com.example.arandatest.model.Asignacion;
import com.example.arandatest.model.Estudiante;
import com.example.arandatest.model.Examen;
import com.example.arandatest.payload.AsignacionInEp;
import com.example.arandatest.repository.AsignacionRepository;
import com.example.arandatest.repository.EstudianteRepository;
import com.example.arandatest.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/v1/asignaciones")
public class AsignacionController {

    public static final String DATE_DDMMYYYYHHMM = "dd/MM/yyyy HH:mm";

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;


    @PostMapping
    public ResponseEntity<Asignacion> asignarExamen(@RequestBody AsignacionInEp asignacionInEp){
        //TODO validar dato de entrada no null no empty
        Long idExamen = new Long(asignacionInEp.getIdExamen());
        Examen examen = examenRepository.findById(idExamen).orElseThrow(() -> new ResourceNotFoundException("No se encuentra examen con id "+idExamen));

        //TODO validar dato de entrada no null no empty
        Long idEstudiante = new Long(asignacionInEp.getIdEstudiante());
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow(()->new ResourceNotFoundException("No se encuentra estudiante con id "+idEstudiante));

        Asignacion asignacion = new Asignacion(examen, estudiante,
                string2ZonedDateTimeZone(asignacionInEp.getFechaHora(), DATE_DDMMYYYYHHMM, examen.getZonaHoraria()),
                string2ZonedDateTimeZone(asignacionInEp.getFechaHora(), DATE_DDMMYYYYHHMM, estudiante.getZonaHoraria()));
        return ResponseEntity.ok(asignacionRepository.save(asignacion));
    }

    public static ZonedDateTime string2ZonedDateTimeZone(String valor,String formato,String zoneId){
        ZonedDateTime finVigencia = null;
        try {
            finVigencia = ZonedDateTime.parse(valor, DateTimeFormatter.ofPattern(formato).withZone(ZoneId.of(zoneId)));
        }catch(Exception e){
            System.out.println("Error en el casteo de la fecha " + e);
        }
        return finVigencia;
    }
}
