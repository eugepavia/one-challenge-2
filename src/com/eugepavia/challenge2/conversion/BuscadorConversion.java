package com.eugepavia.challenge2.conversion;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

// recibe objeto JSON con los datos de la moneda
// extrae la tasa de conversión correspondiente a lo indicado por el usuario
public class BuscadorConversion {

    public double adquiereTasa(String json, String moneda) {
        JsonObject conversiones = JsonParser.parseString(json)
                .getAsJsonObject()
                .getAsJsonObject("conversion_rates");

        return conversiones.get(moneda).getAsDouble();
    }


}
