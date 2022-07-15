package com.example.arandatest.controller;

import com.example.arandatest.exception.ResourceNotFoundException;
import com.example.arandatest.model.Estudiante;
import com.example.arandatest.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping
    public List<Estudiante> getAllEstudiantes(){
        return estudianteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante){
        return ResponseEntity.ok(estudianteRepository.save(estudiante));
    }

    @GetMapping("{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable long id){
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encuentra estudiante con id: "+id));

        return ResponseEntity.ok(estudiante);
    }
}
