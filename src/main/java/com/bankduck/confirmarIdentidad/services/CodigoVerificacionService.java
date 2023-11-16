package com.bankduck.confirmarIdentidad.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;

@Service
public class CodigoVerificacionService {
    @Value("${server.validarInformacionCliente.url}")  // Configura la URL del servidor B en tu archivo application.properties
    private String servervalidarInformacionClienteUrl;
    public void generarCodigo(String stringCedula) {
        Long cedula = Long.parseLong(stringCedula);
        WebClient webClient = WebClient.builder()
                .baseUrl(servervalidarInformacionClienteUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + encodeCredentials("admin", "admin"))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        // Llama al endpoint del servidor B
        webClient.method(HttpMethod.GET)
                .uri("/validacionCliente/generarCodigo/{cedula}", cedula)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> {
                    // Maneja la respuesta aquí
                    System.out.println("Respuesta del servidor: " + response);
                });

    }

    private String encodeCredentials(String username, String password) {
        // Implementa la codificación de credenciales aquí
        // Puedes usar Base64.encode o cualquier otra implementación
        return Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }
}
