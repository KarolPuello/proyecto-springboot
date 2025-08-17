package com.proyecto.proyecto_springboot.service;

import com.proyecto.proyecto_springboot.Model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AlumnoService {
    Page<Alumno> findAll(Pageable pageable);
    Optional<Alumno> findById(Integer id);
    Alumno create(Alumno alumno);
    Alumno update(Integer id, Alumno alumno);
    void deleteById(Integer id);
}
