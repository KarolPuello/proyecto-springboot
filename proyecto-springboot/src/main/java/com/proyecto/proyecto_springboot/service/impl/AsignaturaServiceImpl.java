package com.proyecto.proyecto_springboot.service.impl;

import com.proyecto.proyecto_springboot.Model.Asignatura;
import com.proyecto.proyecto_springboot.Repository.AsignaturaRepository;
import com.proyecto.proyecto_springboot.service.AsignaturaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    @Override
    public Page<Asignatura> findAll(Pageable pageable) {
        return asignaturaRepository.findAll(pageable);
    }

    @Override
    public Optional<Asignatura> findById(Long id) {
        return asignaturaRepository.findById(id);
    }

    @Override
    public Asignatura create(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura update(Long id, Asignatura asignatura) {
        asignatura.setId_asignatura(id);
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public void deleteById(Long id) {
        asignaturaRepository.deleteById(id);
    }
}