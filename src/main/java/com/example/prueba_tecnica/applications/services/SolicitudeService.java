package com.example.prueba_tecnica.applications.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.prueba_tecnica.domain.dto.ProcessResponse;
import com.example.prueba_tecnica.domain.dto.SolicitudeRequest;
import com.example.prueba_tecnica.domain.dto.SolicitudeResponse;

public interface SolicitudeService {
    SolicitudeResponse saveSolicitude(SolicitudeRequest request, String archivoRuta);
    ProcessResponse updateSolicitude(Long id, String estado);
    ProcessResponse deleteSolicitude(Long id);
    Page<SolicitudeResponse> getAllSolicitude(Pageable  pageable);
}

