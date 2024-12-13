package com.example.prueba_tecnica.applications.services;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.prueba_tecnica.domain.entity.Solicitude;
import com.example.prueba_tecnica.domain.repository.SolicitudeRepository;
import com.example.prueba_tecnica.infrastucture.excel.ExcelGenerator;

@Service
public class ReportService {

    private final SolicitudeRepository solicitudRepository;

    public ReportService(SolicitudeRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public String generarReporteExcel() throws IOException {
        List<Solicitude> solicitudes = solicitudRepository.findAll();
        return ExcelGenerator.generarReporteExcel(solicitudes);
    }
}
