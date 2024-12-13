package com.example.prueba_tecnica.domain.dto;

import lombok.Data;

@Data
public class SolicitudResponse {
    private Long id;
    private String nombreCompleto;
    private String estado;
    private String rutaArchivo;
}
