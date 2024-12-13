package com.example.prueba_tecnica.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SolicitudeResponse {
    private Long id;
    private String nombreCompleto;
    private String identificacion;
    private String email;
    private String telefono;
    private String estado;
    private String motivoSolicitud;
    private Double sueldoDevengado;
    private String estadoCivil;
    private Integer dependientes;
    private String rutaArchivo;
    private LocalDateTime fechaCreacion;
}
