package com.proyecto.proyecto_springboot.Controller;

import com.proyecto.proyecto_springboot.Model.Asignatura;
import com.proyecto.proyecto_springboot.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService AsignaturaService;

    @GetMapping
    public Page<Asignatura> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return AsignaturaService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Asignatura getById(@PathVariable Long id) {
        return AsignaturaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura not found with id: " + id));
    }

    @PostMapping
    public Asignatura create(@RequestBody Asignatura asignatura){
        return AsignaturaService.create(asignatura);
    }

    @PutMapping("/{id}")
    public Asignatura update(@PathVariable Long id, @RequestBody Asignatura asignatura){
        return AsignaturaService.update(id, asignatura);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        AsignaturaService.deleteById(id);
    }
}
