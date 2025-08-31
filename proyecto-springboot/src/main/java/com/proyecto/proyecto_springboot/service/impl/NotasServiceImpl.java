package com.proyecto.proyecto_springboot.service.impl;

import com.proyecto.proyecto_springboot.Model.Notas;
import com.proyecto.proyecto_springboot.Repository.NotasRepository;
import com.proyecto.proyecto_springboot.service.NotasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotasServiceImpl implements NotasService {

    private final NotasRepository notasRepository;

    public NotasServiceImpl(NotasRepository notasRepository) {
        this.notasRepository = notasRepository;
    }

    @Override
    public List<Notas> findAll() {
        return notasRepository.findAll();
    }

    @Override
    public Optional<Notas> findById(Long id) {
        return notasRepository.findById(id);
    }

    @Override
    public Notas save(Notas nota) {
        return notasRepository.save(nota);
    }

    @Override
    public void deleteById(Long id) {
        notasRepository.deleteById(id);
    }
}
