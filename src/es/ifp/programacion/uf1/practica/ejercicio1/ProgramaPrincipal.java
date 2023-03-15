package es.ifp.programacion.uf1.practica.ejercicio1;

import java.util.Locale;
import java.util.Scanner;

public class ProgramaPrincipal {
    /**
     * Este programa es una calculadora que permite realizar operaciones matemáticas básicas y algunas más avanzadas,
     * como el cálculo del factorial de un número.
     * El programa utiliza la entrada de usuario a través de la clase Scanner y presenta un menú que permite al usuario
     * seleccionar la operación que desea ejecutar. Las opciones del menú incluyen suma, resta, multiplicación, división,
     * y resto. Si se selecciona una de las opciones que requieren dos números, el programa pedirá al usuario que
     * ingrese los dos números. Si se selecciona una opción que solo requiere un número, se pedirá al usuario que ingrese
     * un solo número. Después de ejecutar la operación, se mostrará el resultado al usuario.
     * Además, el programa incluye una opción para salir del bucle y finalizar la ejecución.
     *
     * @param args Los argumentos de línea de comandos no se utilizan en este programa
     */
    public static void main(String[] args) {
        // Creación del objeto Scanner para leer datos de entrada
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        // Variables para la lógica de la calculadora
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // Variables para la presentación de resultados
        String resultMessage;
        String option;
        String operation = "";

        //Condiciones de salida
        boolean exit = false;
        boolean isOptionValid = true;


        String bar = "============================================================";
        System.out.println("============ CALCULADORA :: GESTIÓN DE AGUAS, SL ============");

        do {
            System.out.println("Introduzca una opción del menu:");
            System.out.println("1. Sumar(+)");
            System.out.println("2. Restar(-)");
            System.out.println("3. Multiplicar(*)");
            System.out.println("4. Dividir(/)");
            System.out.println("5. Resto(%)");
            System.out.println("6. Salir (S o s)");
            System.out.println("Introduzca una opción:");

            option = sc.next();

            switch (option) {
                case "1":
                    System.out.println("Introduzca el primer número:");
                    num1 = sc.nextFloat();
                    System.out.println("Introduzca el segundo número:");
                    num2 = sc.nextFloat();
                    result = num1 + num2;
                    operation = "suma";
                    break;
                case "2":
                    System.out.println("Introduzca el primer número:");
                    num1 = sc.nextFloat();
                    System.out.println("Introduzca el segundo número:");
                    num2 = sc.nextFloat();
                    result = num1 - num2;
                    operation = "resta";
                    break;
                case "3":
                    System.out.println("Introduzca el primer número:");
                    num1 = sc.nextFloat();
                    System.out.println("Introduzca el segundo número:");
                    num2 = sc.nextFloat();
                    result = num1 * num2;
                    operation = "multiplicación";
                    break;
                case "4":
                    System.out.println("Introduzca el primer número:");
                    num1 = sc.nextFloat();
                    System.out.println("Introduzca el segundo número:");
                    num2 = sc.nextFloat();
                    result = num1 / num2;
                    operation = "división";
                    break;
                case "5":
                    System.out.println("Introduzca el primer número:");
                    num1 = sc.nextFloat();
                    System.out.println("Introduzca el segundo número:");
                    num2 = sc.nextFloat();
                    result = num1 % num2;
                    operation = "resto";
                    break;
                case "6":
                case "s":
                case "S":
                    System.out.println("El programa ha finalizado.");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    isOptionValid = false;
                    break;
            }

            if (!exit && isOptionValid) {
                resultMessage = String.format(Locale.US, "La %s entre %.2f y %.2f es %.2f", operation, num1, num2,
                        result);
                System.out.println(bar);
                System.out.println(resultMessage);
                System.out.println(bar);
            }

        } while (!exit);
        sc.close();
    }
}
