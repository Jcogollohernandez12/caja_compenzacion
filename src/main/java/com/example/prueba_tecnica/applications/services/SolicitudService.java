package com.example.prueba_tecnica.applications.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba_tecnica.domain.dto.ProcessResponse;
import com.example.prueba_tecnica.domain.dto.SolicitudeRequest;
import com.example.prueba_tecnica.domain.dto.SolicitudeResponse;
import com.example.prueba_tecnica.domain.entity.Solicitude;
import com.example.prueba_tecnica.domain.repository.SolicitudeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudeRepository solicitudeRepository;

    public SolicitudeResponse saveSolicitude(SolicitudeRequest request, String archivoRuta) {
        Solicitude solicitude = mapToEntity(request, archivoRuta);
        solicitude = solicitudeRepository.save(solicitude);
        return mapToResponse(solicitude);
    }

    public ProcessResponse updateSolicitud(Long id, String estado) {
        Solicitude solicitud = solicitudeRepository.findById(id).orElse(null);
        if (solicitud == null) {
            return new ProcessResponse("Solicitud " + id + " no encontrada en la base de datos", false, 404);
        }
        solicitud.setEstado(estado);
        solicitudeRepository.save(solicitud);
        return new ProcessResponse("Solicitud " + solicitud.getId() + " actualizada" + " a " + estado, true, 200);
    }

    public ProcessResponse deleteSolicitud(Long id) {
        Solicitude solicitud = solicitudeRepository.findById(id).orElse(null);
        if (solicitud == null) {
            return new ProcessResponse("Solicitud " + id + " no encontrada en la base de datos", false, 404);
        }
        solicitudeRepository.delete(solicitud);
        return new ProcessResponse("Solicitud " + solicitud.getId() + " eliminada", true, 200);
    }

   public List<SolicitudeResponse> getAllSolicitud() {
        return solicitudeRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    private Solicitude mapToEntity(SolicitudeRequest request, String archivoRuta) {
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


    private SolicitudeResponse mapToResponse(Solicitude solicitude) {
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
