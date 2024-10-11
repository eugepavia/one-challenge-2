package com.eugepavia.challenge2.claves;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

// recibe el json con todos las claves y la clave que el usuario desea revisar
// devuelve true si la clave está disponible, false si no se encuentra en el catálogo

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
