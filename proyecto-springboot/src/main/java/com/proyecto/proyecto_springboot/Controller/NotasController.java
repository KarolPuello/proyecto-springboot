package com.proyecto.proyecto_springboot.Controller;

import com.proyecto.proyecto_springboot.Model.Notas;
import com.proyecto.proyecto_springboot.service.NotasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notas")
public class NotasController {

    private final NotasService notasService;

    public NotasController(NotasService notasService) {
        this.notasService = notasService;
    }

    @GetMapping
    public List<Notas> getAllNotas() {
        return notasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notas> getNotaById(@PathVariable Long id) {
        Optional<Notas> nota = notasService.findById(id);
        return nota.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Notas> createNota(@RequestBody Notas nota) {
        Notas savedNota = notasService.save(nota);
        return ResponseEntity.created(URI.create("/api/notas/" + savedNota.getId())).body(savedNota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notas> updateNota(@PathVariable Long id, @RequestBody Notas nota) {
        if (notasService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        nota.setId(id);
        Notas updatedNota = notasService.save(nota);
        return ResponseEntity.ok(updatedNota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Long id) {
        if (notasService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        notasService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

