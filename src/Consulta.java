import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// crea la conexión entre el usuario y la API (cliente, solicitud, respuesta)
// recibe la entrada de la moneda base del usuario (que desea convertir en otra)
// devuelve objeto JSON con los datos y las tasas de conversion de esa moneda base a todas las monedas de la API

public class Consulta {

    public String realizaBusqueda(String entrada) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/f43772ce4fe169f01f8c7903/latest/"+entrada))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se pudo realizar la conversión");
        }
    }


}
