package com.eugepavia.challenge2.conversion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Recibe la clave de la moneda origen del usuario
// Devuelve un objeto String en formato JSON con los datos y las tasas de conversion de la moneda origen a todas las monedas disponibles en la API

public class ConsultaConversion {

    public String realizaBusqueda(String entrada) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/f43772ce4fe169f01f8c7903/latest/"+entrada))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ocurrió un error inesperado");
        }
    }

}
