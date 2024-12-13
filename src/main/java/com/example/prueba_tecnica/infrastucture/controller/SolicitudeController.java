package com.example.prueba_tecnica.infrastucture.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.prueba_tecnica.applications.services.SolicitudService;
import com.example.prueba_tecnica.domain.dto.ProcessResponse;
import com.example.prueba_tecnica.domain.dto.SolicitudeRequest;
import com.example.prueba_tecnica.domain.dto.SolicitudeResponse;
import com.example.prueba_tecnica.utils.FileValidator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudeController {

    @Autowired
    private SolicitudService solicitudService;
    
    @PostMapping(value = "/create/{name}/{indentificador}/{email}/{phone}/{reason}/{value}/{status}/{dependency}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(
        summary = "Crear una solicitud",
        responses = {
            @ApiResponse(responseCode = "201", description = "Solicitud creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Error al crear la solicitud"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )
    public SolicitudeResponse registrarSolicitud(
        @PathVariable String name,
        @PathVariable String indentificador,
        @PathVariable String email,
        @PathVariable String phone,
        @PathVariable String reason,
        @PathVariable Double value,
        @PathVariable String status,
        @PathVariable Integer dependency,
        @RequestPart(value = "file", required = true) @Schema(type = "string", format = "binary", description = "Archivo PDF para la solicitud") MultipartFile file
    ) throws IOException {

        SolicitudeRequest request = new SolicitudeRequest(name, indentificador, email, phone, reason, value, status, dependency);
        FileValidator.validarPDF(file);
        String pathFile = FileValidator.saveFile(file, "");
        return solicitudService.saveSolicitude(request, pathFile);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
    summary = "Eliminar una solicitud por ID",
    responses = {
        @ApiResponse(responseCode = "200", description = "Solicitud eliminada correctamente"),
        @ApiResponse(responseCode = "404", description = "Solicitud no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    }
)
    public ProcessResponse  deleteSolicitud(@PathVariable Long id) {
        return solicitudService.deleteSolicitud(id);
    }

    @PutMapping("update/{id}/{entity}")
    @Operation(
        summary = "Actualizar una solicitud por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Solicitud actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Solicitud no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
        }
    )
    public ProcessResponse  updateSolicitud(@PathVariable String id, @PathVariable String entity) {
        return solicitudService.updateSolicitud(Long.parseLong(id), entity);
    
    }

    @GetMapping("getAllSolicitud")
    public List<SolicitudeResponse> getAllSolicitud() {
        return solicitudService.getAllSolicitud();
    }
    
}