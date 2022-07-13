package com.example.arandatest;

import com.example.arandatest.model.Examen;
import com.example.arandatest.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArandatestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ArandatestApplication.class, args);
    }

    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public void run(String... args) throws Exception {
        /*Examen examen1 = new Examen();
        examen1.setCodigoExamen("ExamenPrueba");
        examen1.setNombreExamen("Examen de Prueba");
        examen1.setZonaHoraria("America/New_York");
        examenRepository.save(examen1);

        Examen examen2 = new Examen();
        examen2.setCodigoExamen("ExamenPrueba");
        examen2.setNombreExamen("Examen de Prueba");
        examen2.setZonaHoraria("America/Buenos_Aires");
        examenRepository.save(examen2);*/
    }
}
