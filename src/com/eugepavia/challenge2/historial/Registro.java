package com.eugepavia.challenge2.historial;

import java.time.LocalDateTime;

public record Registro(LocalDateTime fecha,
                       String monedaOrigen,
                       String monedaDestino,
                       double cantidad,
                       double resultado,
                       double tasa) {

    @Override
    public String toString() {
        String texto = """
                [%tD %tT] %.2f %s -> %.2f %s (tasa = %.4f)""".formatted(fecha,fecha,cantidad,monedaOrigen,resultado,monedaDestino,tasa);
        return texto;
    }
}
