import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String monedaInicial;
        String monedaFinal;
        double cantidad;
        boolean band = true;

        String menuClaves = """
                ****************************************************
                                $$ MENU DE CLAVES $$
                CLAVE          MONEDA                  PAIS
                 ARS  -  Peso argentino        -  Argentina
                 BOB  -  Boliviano boliviano   -  Bolivia
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
                1 - Ver claves
                2 - Convertir moneda
                3 - Salir
                ************************************""";


        while (band) {
            System.out.println(menuInicio);
            Scanner lectura = new Scanner(System.in);
            try {
                int teclado = lectura.nextInt();
                switch (teclado) {
                    case 1:
                        System.out.println(menuClaves);
                        break;

                    case 2:
                        Consulta consulta = new Consulta();
                        Buscador buscador = new Buscador();
                        Calculos calculos = new Calculos();

                        try {
                            lectura.nextLine();
                            System.out.println("Clave de la moneda original:");
                            monedaInicial = lectura.nextLine().toUpperCase();
                            String json = consulta.realizaBusqueda(monedaInicial);

                            System.out.println("Clave de la moneda destino:");
                            monedaFinal = lectura.nextLine().toUpperCase();
                            double tasa = buscador.adquiereTasa(json,monedaFinal);

                            System.out.println("Monto de dinero:");
                            cantidad = lectura.nextDouble();
                            double resultado = calculos.calculaCambio(tasa,cantidad);

                            System.out.println(cantidad+" "+monedaInicial+" equivale a "+resultado+" "+monedaFinal);
                            System.out.println("Tasa de cambio: "+tasa);
                        } catch (Exception e) {
                            System.out.println("Entrada no válida. Intente de nuevo");
                        }
                        break;

                    case 3:
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
