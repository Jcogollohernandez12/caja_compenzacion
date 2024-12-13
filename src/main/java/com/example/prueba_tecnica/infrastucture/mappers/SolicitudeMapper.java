package com.example.prueba_tecnica.infrastucture.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.prueba_tecnica.domain.dto.SolicitudeRequest;
import com.example.prueba_tecnica.domain.dto.SolicitudeResponse;
import com.example.prueba_tecnica.domain.entity.Solicitude;

@Component
public class SolicitudeMapper {

    public Solicitude toEntity(SolicitudeRequest request, String archivoRuta) {
        Solicitude solicitude = new Solicitude();
        solicitude.setNombreCompleto(request.getNombreCompleto());
        solicitude.setIdentificacion(request.getIdentificacion());
        solicitude.setCorreoElectronico(request.getCorreoElectronico());
        solicitude.setTelefono(request.getTelefono());
        solicitude.setMotivoSolicitud(request.getMotivoSolicitud());
        solicitude.setSueldoDevengado(request.getSueldoDevengado());
        solicitude.setEstadoCivil(request.getEstadoCivil());
        solicitude.setDependientes(request.getDependientes());
        solicitude.setEstado("Abierto");
        solicitude.setFechaCreacion(LocalDateTime.now());
        solicitude.setRutaArchivo(archivoRuta);
        return solicitude;
    }

    public SolicitudeResponse toResponse(Solicitude solicitude) {
        SolicitudeResponse response = new SolicitudeResponse();
        response.setId(solicitude.getId());
        response.setNombreCompleto(solicitude.getNombreCompleto());
        response.setEstado(solicitude.getEstado());
        response.setRutaArchivo(solicitude.getRutaArchivo());
        response.setIdentificacion(solicitude.getIdentificacion());
        response.setEmail(solicitude.getCorreoElectronico());
        response.setTelefono(solicitude.getTelefono());
        response.setMotivoSolicitud(solicitude.getMotivoSolicitud());
        response.setSueldoDevengado(solicitude.getSueldoDevengado());
        response.setEstadoCivil(solicitude.getEstadoCivil());
        response.setDependientes(solicitude.getDependientes());
        response.setFechaCreacion(solicitude.getFechaCreacion());
        return response;
    }
}
