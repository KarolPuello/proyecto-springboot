package com.proyecto.proyecto_springboot.service;

import com.proyecto.proyecto_springboot.Model.Notas;
import java.util.List;
import java.util.Optional;

public interface NotasService {
    List<Notas> findAll();
    Optional<Notas> findById(Long id);
    Notas save(Notas nota);
    void deleteById(Long id);
}

