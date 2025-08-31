package com.proyecto.proyecto_springboot.Repository;

import com.proyecto.proyecto_springboot.Model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}
