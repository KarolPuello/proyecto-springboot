package com.proyecto.proyecto_springboot.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "asignaturas")
@Data
public class Asignatura {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id_asignatura;

    private String nombre_asignatura;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;
}
