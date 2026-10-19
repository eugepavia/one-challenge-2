# Conversor de moneda

![Created](https://img.shields.io/badge/Created-Oct_2024-248f24)
![Version](https://img.shields.io/badge/Version-1.0-c42121)
![Made with](https://img.shields.io/badge/Made_with-Java-255074)



## :memo: Descripción

Aplicación de consola para la conversión de monedas de distintos países. Realiza el cálculo de la equivalencia de una moneda a otra, según la tasa de cambio actual.

> Este trabajo fue elaborado como parte de la formación *Java Orientado a Objetos (Challenge)* de Oracle Next Education (ONE).

## :dart: Características

La aplicación cuenta con las siguientes opciones:

    ************************************
          $$ CONVERSOR DE MONEDAS $$
    Seleccione una opción del menú:
    1 - Ver ejemplos de claves
    2 - Buscar disponibilidad de clave
    3 - Convertir moneda
    4 - Historial de conversiones
    
    0 - Salir
    ************************************

1. Guía con las claves más utilizadas, la moneda a la que hacen referencia y el país al que corresponden.
2. Opción para revisar si una clave específica se encuentra disponible en el catálogo de claves de la aplicación.
3. Conversor de moneda. Requiere ingresar la clave de la moneda origen (antes del cambio), la clave de la moneda destino (después del cambio) y el monto que se desea convertir.
   - El resultado incluye la tasa utilizada para la conversión.
4. Registro de las conversiones realizadas durante el uso de la aplicación.
0. Cerrar la aplicación.

Las tasas de conversión se extraen de *ExchangeRate-API*: <https://www.exchangerate-api.com/>

## :white_check_mark: Requisitos
- Duplicar el archivo _config.example.properties_ de la carpeta _resources_, renombrar a _config.properties_ y agregar las variables de entorno correspondientes:
  - api.key: Clave de acceso a la API utilizada
  - api.url: Cambiar solo en caso de actualización de la URL para la API

## :wave: Sobre mí
¡Hola! Soy Eugenia, programadora Backend en crecimiento. Empecé como profesora de matemáticas, pero mi interés por el desarrollo de software me llevó a formarme en tecnologías Backend.

Me entusiasma seguir aprendiendo, compartir mis conocimientos y poner mis habilidades al servicio de proyectos que aporten valor. ¿Empezamos?