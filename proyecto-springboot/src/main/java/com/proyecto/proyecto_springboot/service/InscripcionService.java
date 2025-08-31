package com.proyecto.proyecto_springboot.service;

import com.proyecto.proyecto_springboot.Model.Inscripcion;
import java.util.List;
import java.util.Optional;

public interface InscripcionService {
    List<Inscripcion> getAllInscripciones();
    Optional<Inscripcion> getInscripcionById(Long id);
    Inscripcion saveInscripcion(Inscripcion inscripcion);
    void deleteInscripcion(Long id);
}
