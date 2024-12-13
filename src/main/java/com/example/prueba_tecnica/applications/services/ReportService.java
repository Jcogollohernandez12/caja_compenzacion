package com.example.prueba_tecnica.applications.services;
import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.prueba_tecnica.domain.entity.Solicitude;
import com.example.prueba_tecnica.domain.repository.SolicitudeRepository;
import com.example.prueba_tecnica.infrastucture.excel.ExcelGenerator;

@Service
public class ReportService {

    private final SolicitudeRepository solicitudeRepository;

    public ReportService(SolicitudeRepository solicitudRepository) {
        this.solicitudeRepository = solicitudRepository;
    }

    public String generateReportExcel() throws IOException {
        List<Solicitude> solicitude = solicitudeRepository.findAll(Pageable.unpaged()).getContent();
        return ExcelGenerator.generarReporteExcel(solicitude);
    }
}
