package com.example.prueba_tecnica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba_tecnica.dto.ProcessResponse;
import com.example.prueba_tecnica.dto.SolicitudRequest;
import com.example.prueba_tecnica.dto.SolicitudResponse;
import com.example.prueba_tecnica.entity.Solicitud;
import com.example.prueba_tecnica.repository.SolicitudRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public SolicitudResponse registrarSolicitud(SolicitudRequest request, String archivoRuta) {
        Solicitud solicitud = new Solicitud();
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

        solicitud = solicitudRepository.save(solicitud);

        SolicitudResponse response = new SolicitudResponse();
        response.setId(solicitud.getId());
        response.setNombreCompleto(solicitud.getNombreCompleto());
        response.setEstado(solicitud.getEstado());
        response.setRutaArchivo(solicitud.getRutaArchivo());
        return response;
    }

    public ProcessResponse updateSolicitud(Long id, String estado) {
        Solicitud solicitud = solicitudRepository.findById(id).orElse(null);
        if (solicitud == null) {
            ProcessResponse response = new ProcessResponse( );
            return response.copyWProcessResponse("Solicitud " + id + " no encontrada en la base de datos", false, 404);
        }
        solicitud.setEstado(estado);
        solicitudRepository.save(solicitud);
        ProcessResponse response = new ProcessResponse( );
        return response.copyWProcessResponse("Solicitud " + solicitud.getId() + " actualizada" + " a " + estado, true, 200);
    }

    public ProcessResponse deleteSolicitud(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id).orElse(null);
        if (solicitud == null) {
            ProcessResponse response = new ProcessResponse( );
            return response.copyWProcessResponse("Solicitud " + id + " no encontrada en la base de datos", false, 404);
        }
        solicitudRepository.delete(solicitud);
        ProcessResponse response = new ProcessResponse( );
        return response.copyWProcessResponse("Solicitud " + solicitud.getId() + " eliminada", true, 200);
    }

    public List<SolicitudResponse> getAllSolicitud() {
        List<SolicitudResponse> response = new java.util.ArrayList<>();
        for (Solicitud solicitud : solicitudRepository.findAll()) {
            SolicitudResponse solicitudResponse = new SolicitudResponse();
            solicitudResponse.setId(solicitud.getId());
            solicitudResponse.setNombreCompleto(solicitud.getNombreCompleto());
            solicitudResponse.setEstado(solicitud.getEstado());
            response.add(solicitudResponse);
        }
        return response;
    }

}
