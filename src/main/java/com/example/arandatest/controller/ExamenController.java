package com.example.arandatest.controller;

import com.example.arandatest.exception.ResourceNotFoundException;
import com.example.arandatest.model.Examen;
import com.example.arandatest.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/examenes")
public class ExamenController {

    @Autowired
    private ExamenRepository examenRepository;

    @GetMapping
    public List<Examen> getAllExamenes(){
        return examenRepository.findAll();
    }

    @PostMapping
    public Examen createExamen(@RequestBody Examen examen){
        return examenRepository.save(examen);
    }

    @GetMapping("{id}")
    public ResponseEntity<Examen> getExamenById(@PathVariable long id){
        Examen examen = examenRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentra el examen con id: "+id));
        return ResponseEntity.ok(examen);
    }
}
