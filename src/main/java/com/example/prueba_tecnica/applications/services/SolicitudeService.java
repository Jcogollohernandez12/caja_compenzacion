package com.example.prueba_tecnica.applications.services;

import java.util.List;

import com.example.prueba_tecnica.domain.dto.ProcessResponse;
import com.example.prueba_tecnica.domain.dto.SolicitudeRequest;
import com.example.prueba_tecnica.domain.dto.SolicitudeResponse;

public interface SolicitudeService {
    SolicitudeResponse saveSolicitude(SolicitudeRequest request, String archivoRuta);
    ProcessResponse updateSolicitude(Long id, String estado);
    ProcessResponse deleteSolicitude(Long id);
    List<SolicitudeResponse> getAllSolicitude();
}

