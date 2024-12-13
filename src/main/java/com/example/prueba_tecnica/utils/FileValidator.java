package com.example.prueba_tecnica.utils;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class FileValidator {

    @SuppressWarnings("null")
    public static void validarPDF(MultipartFile file) throws IllegalArgumentException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("El archivo no puede estar vacío.");
        }

        if (!file.getContentType().equals("application/pdf")) {
            throw new IllegalArgumentException("El archivo debe ser un PDF.");
        }
        if (file.getSize() > 5 * 1024 * 1024) { // 5 MB
            throw new IllegalArgumentException("El archivo no debe superar los 5 MB.");
        }
    }

    public static String saveFile(MultipartFile file, String directoire) throws IOException {
        String pathFile = directoire + file.getOriginalFilename();
        file.transferTo(new java.io.File(pathFile));
        return pathFile;
    }

    public static String convertToBase64(MultipartFile file) throws IOException {
       Base64.Encoder encoder = Base64.getEncoder();
       //String baseString = encoder.encodeToString(file.getBytes());
        return "";
    }
}