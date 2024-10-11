package com.eugepavia.challenge2.claves;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Recupera de la API la información de todas las monedas disponibles en el catálogo, con sus claves y países de origen
// Devuelve un objeto String en formato JSON con los datos de estas monedas

public class ConsultaClaves {

    public String realizaBusqueda() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/f43772ce4fe169f01f8c7903/codes/"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ocurrió un error inesperado");
        }

    }

}
