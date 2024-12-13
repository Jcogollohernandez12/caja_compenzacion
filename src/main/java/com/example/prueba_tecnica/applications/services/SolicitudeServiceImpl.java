package com.example.prueba_tecnica.applications.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.prueba_tecnica.domain.dto.ProcessResponse;
import com.example.prueba_tecnica.domain.dto.SolicitudeRequest;
import com.example.prueba_tecnica.domain.dto.SolicitudeResponse;
import com.example.prueba_tecnica.domain.entity.Solicitude;
import com.example.prueba_tecnica.domain.repository.SolicitudeRepository;
import com.example.prueba_tecnica.infrastucture.mappers.SolicitudeMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudeServiceImpl implements SolicitudeService {

    @Autowired
    private SolicitudeRepository solicitudeRepository;
    @Autowired
    private  SolicitudeMapper solicitudeMapper;


    @Override
    public SolicitudeResponse saveSolicitude(SolicitudeRequest request, String archivoRuta) {
        Solicitude solicitude = solicitudeMapper.toEntity(request, archivoRuta);
        solicitude = solicitudeRepository.save(solicitude);
        return solicitudeMapper.toResponse(solicitude);
    }
    @Override
    public ProcessResponse updateSolicitude(Long id, String estado) {
        Solicitude solicitud = solicitudeRepository.findById(id).orElse(null);
        if (solicitud == null) {
            return new ProcessResponse("Solicitud " + id + " no encontrada en la base de datos", false, 404);
        }
        solicitud.setEstado(estado);
        solicitudeRepository.save(solicitud);
        return new ProcessResponse("Solicitud " + solicitud.getId() + " actualizada" + " a " + estado, true, 200);
    }

    @Override
    public ProcessResponse deleteSolicitude(Long id) {
        Solicitude solicitud = solicitudeRepository.findById(id).orElse(null);
        if (solicitud == null) {
            return new ProcessResponse("Solicitud " + id + " no encontrada en la base de datos", false, 404);
        }
        solicitudeRepository.delete(solicitud);
        return new ProcessResponse("Solicitud " + solicitud.getId() + " eliminada", true, 200);
    }
    @Override
   public Page<SolicitudeResponse> getAllSolicitude(Pageable pageable) {
    List<SolicitudeResponse> responses = solicitudeRepository.findAll(pageable).stream()
            .map(solicitudeMapper::toResponse)
            .collect(Collectors.toList());
    return new PageImpl<>(responses);
}

}
