package com.example.prueba_tecnica.infrastucture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba_tecnica.applications.services.ReportService;

import io.swagger.v3.oas.annotations.Operation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/api/reportes")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/downloadReport")
    @Operation(summary = "Descargar el reporte de solicitudes",
       tags = {"Reportes"},
       description = "Descargar el reporte de solicitudes")
    public ResponseEntity<byte[]> downloadReport() throws IOException {
        String pathFile = reportService.generarReporteExcel();
        File file = new File(pathFile);
        byte[] content = Files.readAllBytes(file.toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte_solicitudes.xlsx");
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }
}
