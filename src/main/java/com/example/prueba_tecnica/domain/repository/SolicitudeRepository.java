package com.example.prueba_tecnica.domain.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.prueba_tecnica.domain.entity.Solicitude;

public interface SolicitudeRepository {
    Solicitude save(Solicitude solicitude);
    Optional<Solicitude> findById(Long id);
    Page<Solicitude> findAll(Pageable pageable);
    void delete(Solicitude solicitude);
}
