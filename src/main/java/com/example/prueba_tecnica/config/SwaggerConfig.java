package com.example.prueba_tecnica.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Prueba Técnica")
                        .version("1.0")
                        .description("Documentación de la API para el proyecto de prueba técnica")
                        .termsOfService("https://www.example.com/terms")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@example.com")
                                .url("https://www.example.com"))
                        .license(new License()
                                .name("Licencia Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
