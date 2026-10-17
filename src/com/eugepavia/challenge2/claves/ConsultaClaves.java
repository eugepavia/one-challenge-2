package com.eugepavia.challenge2.claves;

import com.eugepavia.challenge2.config.Config;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Recupera de la API la información de todas las monedas disponibles en el catálogo, con sus claves y países de origen
// Devuelve un objeto String en formato JSON con los datos de estas monedas

public class ConsultaClaves {

    String API_URL = Config.get("api.url");

    public String realizaBusqueda(String apiKey) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL+apiKey+"/codes/"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ocurrió un error inesperado");
        }

    }

}
