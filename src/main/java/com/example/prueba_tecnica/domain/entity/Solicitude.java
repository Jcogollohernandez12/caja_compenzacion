package com.example.prueba_tecnica.domain.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes")
public class Solicitude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private String identificacion;
    private String correoElectronico;
    private String telefono;
    private String motivoSolicitud;
    private Double sueldoDevengado;
    private String estadoCivil;
    private Integer dependientes;

    @Column(nullable = false, columnDefinition = "varchar(20) default 'Abierto'")
    private String estado;

    private LocalDateTime fechaCreacion;

    private String rutaArchivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMotivoSolicitud() {
        return motivoSolicitud;
    }

    public void setMotivoSolicitud(String motivoSolicitud) {
        this.motivoSolicitud = motivoSolicitud;
    }

    public Double getSueldoDevengado() {
        return sueldoDevengado;
    }

    public void setSueldoDevengado(Double sueldoDevengado) {
        this.sueldoDevengado = sueldoDevengado;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getDependientes() {
        return dependientes;
    }

    public void setDependientes(Integer dependientes) {
        this.dependientes = dependientes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    
}