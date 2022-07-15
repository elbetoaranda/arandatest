package com.example.arandatest.controller;

import com.example.arandatest.exception.ResourceNotFoundException;
import com.example.arandatest.model.Examen;
import com.example.arandatest.model.Pregunta;
import com.example.arandatest.repository.ExamenRepository;
import com.example.arandatest.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/examenes")
public class ExamenController {

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @GetMapping
    public List<Examen> getAllExamenes(){
        return examenRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Examen> createExamen(@RequestBody Examen examen){
        Examen examenNuevo = examenRepository.save(examen);

        Set<Pregunta> preguntaSet = new HashSet<>();
        for(Pregunta pregunta: examen.getPreguntas()){
            pregunta.setExamen(examenNuevo);
            Pregunta preguntaNueva = preguntaRepository.save(pregunta);
            preguntaSet.add(preguntaNueva);
        }

        examenNuevo.setPreguntas(preguntaSet);

        return ResponseEntity.ok(examenNuevo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Examen> getExamenById(@PathVariable long id){
        Examen examen = examenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentra el examen con id: "+id));
        return ResponseEntity.ok(examen);
    }
}
