package com.example.prueba_tecnica.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.prueba_tecnica.domain.entity.Solicitude;

public interface SolicitudeRepository {
    Solicitude save(Solicitude solicitude);
    Optional<Solicitude> findById(Long id);
    List<Solicitude> findAll();
    void delete(Solicitude solicitude);
}
