package com.proyecto.proyecto_springboot.Controller;

import com.proyecto.proyecto_springboot.Model.Alumno;
import com.proyecto.proyecto_springboot.service.AlumnoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getById(@PathVariable Integer id) {
        return alumnoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alumno> create(@RequestBody Alumno alumno) {
        Alumno creado = alumnoService.create(alumno);
        return ResponseEntity
                .created(URI.create("/api/alumnos/" + creado.getId_alumno()))
                .body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> update(@PathVariable Integer id, @RequestBody Alumno alumno) {
        Alumno actualizado = alumnoService.update(id, alumno);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        alumnoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
