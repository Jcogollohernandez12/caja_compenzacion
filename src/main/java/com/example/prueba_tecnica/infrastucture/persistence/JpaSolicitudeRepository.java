package com.example.prueba_tecnica.infrastucture.persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prueba_tecnica.domain.entity.Solicitude;
import com.example.prueba_tecnica.domain.repository.SolicitudeRepository;

@Repository
public interface JpaSolicitudeRepository extends JpaRepository<Solicitude, Long>, SolicitudeRepository {
}
