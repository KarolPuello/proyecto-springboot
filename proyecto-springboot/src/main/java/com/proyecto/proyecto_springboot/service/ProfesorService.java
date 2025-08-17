package com.proyecto.proyecto_springboot.service;

import com.proyecto.proyecto_springboot.Model.Profesor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProfesorService {
    Page<Profesor> findAll(Pageable pageable);
    Optional<Profesor> findById(Integer id);
    Profesor create(Profesor profesor);
    Profesor update(Integer id, Profesor profesor);
    void deleteById(Integer id);
}


