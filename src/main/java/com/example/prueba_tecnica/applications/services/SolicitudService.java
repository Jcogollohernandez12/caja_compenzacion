package com.example.prueba_tecnica.applications.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba_tecnica.domain.dto.ProcessResponse;
import com.example.prueba_tecnica.domain.dto.SolicitudeRequest;
import com.example.prueba_tecnica.domain.dto.SolicitudResponse;
import com.example.prueba_tecnica.domain.entity.Solicitude;
import com.example.prueba_tecnica.domain.repository.SolicitudeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudeRepository solicitudeRepository;

    public SolicitudResponse registrarSolicitud(SolicitudeRequest request, String archivoRuta) {
        Solicitude solicitud = mapToEntity(request, archivoRuta);
        solicitud = solicitudeRepository.save(solicitud);
        return mapToResponse(solicitud);
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

   public List<SolicitudResponse> getAllSolicitud() {
        return solicitudeRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
    private Solicitude mapToEntity(SolicitudeRequest request, String archivoRuta) {
        Solicitude solicitud = new Solicitude();
        solicitud.setNombreCompleto(request.getNombreCompleto());
        solicitud.setIdentificacion(request.getIdentificacion());
        solicitud.setCorreoElectronico(request.getCorreoElectronico());
        solicitud.setTelefono(request.getTelefono());
        solicitud.setMotivoSolicitud(request.getMotivoSolicitud());
        solicitud.setSueldoDevengado(request.getSueldoDevengado());
        solicitud.setEstadoCivil(request.getEstadoCivil());
        solicitud.setDependientes(request.getDependientes());
        solicitud.setEstado("Abierto");
        solicitud.setFechaCreacion(LocalDateTime.now());
        solicitud.setRutaArchivo(archivoRuta);
        return solicitud;
    }


    private SolicitudResponse mapToResponse(Solicitude solicitud) {
        SolicitudResponse response = new SolicitudResponse();
        response.setId(solicitud.getId());
        response.setNombreCompleto(solicitud.getNombreCompleto());
        response.setEstado(solicitud.getEstado());
        response.setRutaArchivo(solicitud.getRutaArchivo());
        return response;
    }

}
