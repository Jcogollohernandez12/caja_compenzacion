package com.example.prueba_tecnica.domain.dto;

import lombok.Data;

@Data
public class ProcessResponse {
    String message;
    Boolean success;
    int codeStatus;

public ProcessResponse(String message, Boolean success, int codeStatus) {
    this.message = message;
    this.success = success;
    this.codeStatus = codeStatus;
}


}
