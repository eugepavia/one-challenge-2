package com.eugepavia.challenge2.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException("No se pudo hallar el archivo config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Error al leer archivo config.properties", e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalStateException("Falta clave config: " + key);
        }
        return value;
    }
}
