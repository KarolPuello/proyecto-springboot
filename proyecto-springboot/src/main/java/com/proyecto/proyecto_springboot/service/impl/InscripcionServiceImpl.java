package com.proyecto.proyecto_springboot.service.impl;

import com.proyecto.proyecto_springboot.Model.Inscripcion;
import com.proyecto.proyecto_springboot.Repository.InscripcionRepository;
import com.proyecto.proyecto_springboot.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> getAllInscripciones() {
        return inscripcionRepository.findAll();
    }

    @Override
    public Optional<Inscripcion> getInscripcionById(Long id) {
        return inscripcionRepository.findById(id);
    }

    @Override
    public Inscripcion saveInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public void deleteInscripcion(Long id) {
        inscripcionRepository.deleteById(id);
    }
}
