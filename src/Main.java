import com.eugepavia.challenge2.claves.BuscadorClaves;
import com.eugepavia.challenge2.claves.ConsultaClaves;
import com.eugepavia.challenge2.conversion.BuscadorConversion;
import com.eugepavia.challenge2.conversion.Calculos;
import com.eugepavia.challenge2.conversion.ConsultaConversion;
import com.eugepavia.challenge2.historial.Registro;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String monedaOrigen;
        String monedaDestino;
        double cantidad;
        String clave;
        boolean band = true;

        ArrayList<Registro> historial = new ArrayList<>();

        String menuClaves = """
                ****************************************************
                                $$ MENU DE CLAVES $$
                CLAVE          MONEDA                  PAIS
                 BRL  -  Real brasileño        -  Brasil
                 CAD  -  Dólar canadiense      -  Canadá
                 CLP  -  Peso chileno          -  Chile
                 CNY  -  Renminbi chino        -  China
                 COP  -  Peso colombiano       -  Colombia
                 EUR  -  Euro                  -  Unión Europea
                 GBP  -  Libra esterlina       -  Reino Unido
                 JPY  -  Yen japonés           -  Japón
                 KRW  -  Won surcoreano        -  Corea del Sur
                 MXN  -  Peso mexicano         -  México
                 USD  -  Dólar estadounidense  -  Estados Unidos
                ****************************************************""";

        String menuInicio = """
                ************************************
                     $$ CONVERSOR DE MONEDAS $$
                Seleccione una opción del menú:
                1 - Ver ejemplos de claves
                2 - Buscar disponibilidad de clave
                3 - Convertir moneda
                4 - Historial de conversiones
                
                0 - Salir
                ************************************""";


        while (band) {
            System.out.println(menuInicio);
            Scanner lectura = new Scanner(System.in);
            try {
                int teclado = lectura.nextInt();
                switch (teclado) {
                    case 1:  // Ver ejemplos de claves
                        System.out.println(menuClaves);
                        break;

                    case 2:  // Buscar disponibilidad de clave
                        ConsultaClaves consultaClaves = new ConsultaClaves();
                        BuscadorClaves buscadorClaves = new BuscadorClaves();

                        lectura.nextLine();
                        System.out.println("Clave que desea verificar:");
                        clave = lectura.nextLine().toUpperCase();
                        Boolean disponible = buscadorClaves.adquiereClave(consultaClaves.realizaBusqueda(),clave);

                        if (disponible) {
                            System.out.println(clave + " es una clave disponible en el catálogo");
                        } else {
                            System.out.println(clave + " no se encuentra disponible en el catálogo");
                        }
                        break;

                    case 3:  // Convertir moneda
                        ConsultaConversion consultaConversion = new ConsultaConversion();
                        BuscadorConversion buscadorConversion = new BuscadorConversion();
                        Calculos calculos = new Calculos();

                        try {
                            lectura.nextLine();
                            System.out.println("Clave de la moneda original:");
                            monedaOrigen = lectura.nextLine().toUpperCase();
                            String json = consultaConversion.realizaBusqueda(monedaOrigen);

                            System.out.println("Clave de la moneda destino:");
                            monedaDestino = lectura.nextLine().toUpperCase();
                            double tasa = buscadorConversion.adquiereTasa(json,monedaDestino);

                            System.out.println("Monto de dinero:");
                            cantidad = lectura.nextDouble();
                            double resultado = calculos.calculaCambio(tasa,cantidad);

                            System.out.println(cantidad+" "+monedaOrigen+" equivale a "+resultado+" "+monedaDestino);
                            System.out.println("Tasa de cambio: "+tasa);

                            Registro datos = new Registro(LocalDateTime.now(),monedaOrigen,monedaDestino,cantidad,resultado,tasa);
                            historial.add(datos);

                        } catch (Exception e) {
                            System.out.println("Entrada no válida. Intente de nuevo");
                        }
                        break;

                    case 4:  // Historial de conversiones
                        if (historial.isEmpty()) {
                            System.out.println("No se han realizado conversiones");
                        } else {
                            for (Registro i : historial) {
                                System.out.println(i);
                            }
                        }
                        break;

                    case 0:  // Salir
                        band = false;
                        System.out.println("Programa finalizado");
                        break;

                    default:
                        System.out.println("Número no válido. Elija una opción del menú");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Sólo se aceptan números");
            }

        }

    }
}

/*
  __
<(. )__   Eugenia Pavía Ruz
 (____/   Octubre 2024

 */
