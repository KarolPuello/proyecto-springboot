package com.proyecto.proyecto_springboot.Controller;


import com.proyecto.proyecto_springboot.Model.Profesor;
import com.proyecto.proyecto_springboot.service.ProfesorService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private ProfesorService profesorService;

    @GetMapping("/{id}")
    public Profesor getById(@RequestParam Integer id) {
        return profesorService.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor not found with id: " + id));
    }
    @PostMapping
    public Profesor create(@RequestBody Profesor profesor) {
        return profesorService.create(profesor);
    }

    @PutMapping("/{id}")
    public Profesor update(@PathVariable Integer id, @RequestBody Profesor profesor) {
        return profesorService.update(id, profesor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        profesorService.deleteById(id);
    }
}

