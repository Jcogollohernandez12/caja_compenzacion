package com.example.prueba_tecnica.infrastucture.excel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.prueba_tecnica.domain.entity.Solicitude;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelGenerator {

    public static String generarReporteExcel(List<Solicitude> solicitudes) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Solicitudes");

        // Crear encabezados
        Row header = sheet.createRow(0);
        String[] columnas = {"ID", "Nombre Completo", "Identificación", "Correo Electrónico",
                "Teléfono", "Motivo Solicitud", "Valor Devengado", "Estado", "Dependientes", "Fecha de Creación"};
        for (int i = 0; i < columnas.length; i++) {
            header.createCell(i).setCellValue(columnas[i]);
        }

        // Agregar datos
        int rowNum = 1;
        for (Solicitude solicitud : solicitudes) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(solicitud.getId());
            row.createCell(1).setCellValue(solicitud.getNombreCompleto());
            row.createCell(2).setCellValue(solicitud.getIdentificacion());
            row.createCell(3).setCellValue(solicitud.getCorreoElectronico());
            row.createCell(4).setCellValue(solicitud.getTelefono());
            row.createCell(5).setCellValue(solicitud.getMotivoSolicitud());
            row.createCell(6).setCellValue(solicitud.getSueldoDevengado());
            row.createCell(7).setCellValue(solicitud.getEstado());
            row.createCell(8).setCellValue(solicitud.getDependientes());
            row.createCell(9).setCellValue(solicitud.getFechaCreacion().toString());
        }

        String pathFile =  "reporte_solicitudes.xlsx";
        try (FileOutputStream fileOut = new FileOutputStream(pathFile)) {
            workbook.write(fileOut);
        }
        workbook.close();
        return pathFile;
    }
}
