package com.example.prueba_tecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.prueba_tecnica.entity.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}