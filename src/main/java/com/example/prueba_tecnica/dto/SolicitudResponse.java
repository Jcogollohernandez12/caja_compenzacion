package com.example.prueba_tecnica.dto;

import lombok.Data;

@Data
public class SolicitudResponse {
    private Long id;
    private String nombreCompleto;
    private String estado;
    private String rutaArchivo;
}
