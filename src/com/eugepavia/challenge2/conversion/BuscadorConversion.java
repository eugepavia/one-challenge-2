package com.eugepavia.challenge2.conversion;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// Recibe el objeto de ConsultaConversion (string en formato JSON con los datos de la moneda origen y sus tasas de conversion)
// Recibe la clave de la moneda destino del usuario
// Devuelve la tasa de conversión correspondiente a la moneda destino

public class BuscadorConversion {

    public double adquiereTasa(String json, String moneda) {
        JsonObject conversiones = JsonParser.parseString(json)
                .getAsJsonObject()
                .getAsJsonObject("conversion_rates");

        return conversiones.get(moneda).getAsDouble();
    }

}
