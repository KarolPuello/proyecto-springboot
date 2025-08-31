package com.proyecto.proyecto_springboot.Controller;

import com.proyecto.proyecto_springboot.Model.Inscripcion;
import com.proyecto.proyecto_springboot.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public List<Inscripcion> getAllInscripciones() {
        return inscripcionService.getAllInscripciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> getInscripcionById(@PathVariable Long id) {
        Optional<Inscripcion> inscripcion = inscripcionService.getInscripcionById(id);
        return inscripcion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inscripcion createInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.saveInscripcion(inscripcion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> updateInscripcion(@PathVariable Long id, @RequestBody Inscripcion inscripcionDetails) {
        Optional<Inscripcion> inscripcion = inscripcionService.getInscripcionById(id);
        if (inscripcion.isPresent()) {
            Inscripcion updated = inscripcion.get();
            updated.setAlumno(inscripcionDetails.getAlumno());
            updated.setAsignatura(inscripcionDetails.getAsignatura());
            updated.setAnioEscolar(inscripcionDetails.getAnioEscolar());
            return ResponseEntity.ok(inscripcionService.saveInscripcion(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscripcion(@PathVariable Long id) {
        inscripcionService.deleteInscripcion(id);
        return ResponseEntity.noContent().build();
    }
}
