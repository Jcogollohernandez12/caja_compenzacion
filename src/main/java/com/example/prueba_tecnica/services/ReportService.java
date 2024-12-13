package com.example.prueba_tecnica.services;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba_tecnica.entity.Solicitud;
import com.example.prueba_tecnica.repository.SolicitudRepository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private SolicitudRepository solicitudeRepository;

    public String generarReporteExcel(String pathDestine) throws IOException {
        List<Solicitud> solicitude = solicitudeRepository.findAll();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Solicitudes");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Nombre Completo");
        header.createCell(2).setCellValue("Identificación");
        header.createCell(3).setCellValue("Correo Electrónico");
        header.createCell(4).setCellValue("Teléfono");
        header.createCell(5).setCellValue("Motivo Solicitud");
        header.createCell(6).setCellValue("Valor Devengado");
        header.createCell(7).setCellValue("Estado");
        header.createCell(8).setCellValue("Dependientes Economicos");
        header.createCell(9).setCellValue("Fecha de Creación");
        int rowNum = 1;
        for (Solicitud solicited : solicitude) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(solicited.getId());
            row.createCell(1).setCellValue(solicited.getNombreCompleto());
            row.createCell(2).setCellValue(solicited.getIdentificacion());
            row.createCell(3).setCellValue(solicited.getCorreoElectronico());
            row.createCell(4).setCellValue(solicited.getTelefono());
            row.createCell(5).setCellValue(solicited.getMotivoSolicitud());
            row.createCell(6).setCellValue(solicited.getSueldoDevengado());
            row.createCell(7).setCellValue(solicited.getEstado());
            row.createCell(8).setCellValue(solicited.getDependientes());
            row.createCell(9).setCellValue(solicited.getFechaCreacion().toString());
        }
        String pathFile = pathDestine + "reporte_solicitudes.xlsx";
        try (FileOutputStream fileOut = new FileOutputStream(pathFile)) {
            workbook.write(fileOut);
        }
        workbook.close();
        return pathFile;
    }
}
