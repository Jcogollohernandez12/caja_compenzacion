package com.example.prueba_tecnica.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



public class SolicitudRequest {

    @NotNull(message = "El nombre completo no puede estar vacío.")
    @Size(min = 5, max = 100, message = "El nombre completo debe tener entre 5 y 100 caracteres.")
    private String nombreCompleto;

    @NotNull(message = "La identificación no puede estar vacía.")
    @Size(min = 8, max = 15, message = "La identificación debe tener entre 8 y 15 caracteres.")
    private String identificacion;

    @NotNull(message = "El correo electrónico no puede estar vacío.")
    @Email(message = "El correo electrónico no tiene un formato válido.")
    private String correoElectronico;

    @NotNull(message = "El teléfono no puede estar vacío.")
    @Size(min = 10, max = 15, message = "El teléfono debe tener entre 10 y 15 caracteres.")
    private String telefono;

    @NotNull(message = "El motivo de la solicitud no puede estar vacío.")
    @Size(min = 10, max = 255, message = "El motivo de la solicitud debe tener entre 10 y 255 caracteres.")
    private String motivoSolicitud;

    @NotNull(message = "El sueldo devengado no puede estar vacío.")
    @Min(value = 1, message = "El sueldo devengado debe ser mayor que 0.")
    private Double sueldoDevengado;

    @NotNull(message = "El estado civil no puede estar vacío.")
    private String estadoCivil;

    @NotNull(message = "El número de dependientes no puede estar vacío.")
    @Min(value = 0, message = "El número de dependientes no puede ser negativo.")
    private Integer dependientes;

   

    public SolicitudRequest(
            @NotNull(message = "El nombre completo no puede estar vacío.") @Size(min = 5, max = 100, message = "El nombre completo debe tener entre 5 y 100 caracteres.") String nombreCompleto,
            @NotNull(message = "La identificación no puede estar vacía.") @Size(min = 8, max = 15, message = "La identificación debe tener entre 8 y 15 caracteres.") String identificacion,
            @NotNull(message = "El correo electrónico no puede estar vacío.") @Email(message = "El correo electrónico no tiene un formato válido.") String correoElectronico,
            @NotNull(message = "El teléfono no puede estar vacío.") @Size(min = 10, max = 15, message = "El teléfono debe tener entre 10 y 15 caracteres.") String telefono,
            @NotNull(message = "El motivo de la solicitud no puede estar vacío.") @Size(min = 10, max = 255, message = "El motivo de la solicitud debe tener entre 10 y 255 caracteres.") String motivoSolicitud,
            @NotNull(message = "El sueldo devengado no puede estar vacío.") @Min(value = 1, message = "El sueldo devengado debe ser mayor que 0.") Double sueldoDevengado,
            @NotNull(message = "El estado civil no puede estar vacío.") String estadoCivil,
            @NotNull(message = "El número de dependientes no puede estar vacío.") @Min(value = 0, message = "El número de dependientes no puede ser negativo.") Integer dependientes) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.motivoSolicitud = motivoSolicitud;
        this.sueldoDevengado = sueldoDevengado;
        this.estadoCivil = estadoCivil;
        this.dependientes = dependientes;
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

    

}
