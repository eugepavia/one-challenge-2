package com.eugepavia.challenge2.claves;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

// Recibe el objeto de ConsultaClaves (string en formato JSON con los datos de todas las monedas disponibles en el catálogo)
// Recibe la clave de la moneda que el usuario desea consultar
// Devuelve TRUE si la moneda está disponible. Devuelve FALSE si no la encuentra en el catálogo

public class BuscadorClaves  {

    public boolean adquiereClave(String json, String clave) {
        boolean band = false;

        JsonArray conversiones = JsonParser.parseString(json)
                .getAsJsonObject()
                .getAsJsonArray("supported_codes");

        for (JsonElement arreglo :conversiones) {
            if (arreglo.getAsJsonArray().contains(JsonParser.parseString(clave))) {
                band = true;
                break;
            }
        }

        return band;
    }

}
