package es.ifp.programacion.uf1.practica.ejercicio2;

import java.util.Locale;
import java.util.Scanner;

public class ProgramaPrincipal {
    /**
     * Este programa es una calculadora que permite realizar operaciones matemáticas básicas y algunas más avanzadas,
     * como el cálculo del factorial de un número.
     * El programa utiliza la entrada de usuario a través de la clase Scanner y presenta un menú que permite al usuario
     * seleccionar la operación que desea ejecutar. Las opciones del menú incluyen suma, resta, multiplicación, división,
     * resto y factorial. Si se selecciona una de las opciones que requieren dos números, el programa pedirá al usuario que
     * ingrese los dos números. Si se selecciona una opción que solo requiere un número, se pedirá al usuario que ingrese
     * un solo número. Después de ejecutar la operación, se mostrará el resultado al usuario.
     * Además, el programa incluye una opción para salir del bucle y finalizar la ejecución.
     *
     * @param args Los argumentos de línea de comandos no se utilizan en este programa
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        String resultMessage;
        String option;
        String operation = "";

        boolean exit = false;
        boolean isOperation = true;

        System.out.println("============ CALCULADORA :: GESTIÓN DE AGUAS, SL ============");

        do {
            option = menu(sc);

            switch (option) {
                case "1":
                    num1 = getNumericInput(sc, "Introduzca el primer número:");
                    num2 = getNumericInput(sc, "Introduzca el segundo número:");
                    result = sum(num1, num2);
                    operation = "suma";
                    break;
                case "2":
                    num1 = getNumericInput(sc, "Introduzca el primer número:");
                    num2 = getNumericInput(sc, "Introduzca el segundo número:");
                    result = subtract(num1, num2);
                    operation = "resta";
                    break;
                case "3":
                    num1 = getNumericInput(sc, "Introduzca el primer número:");
                    num2 = getNumericInput(sc, "Introduzca el segundo número:");
                    result = multiply(num1, num2);
                    operation = "multiplicación";
                    break;
                case "4":
                    num1 = getNumericInput(sc, "Introduzca el primer número:");
                    num2 = getNumberNonZero(sc, "Introduzca el segundo número:");
                    result = divide(num1, num2);
                    operation = "división";
                    break;
                case "5":
                    num1 = getNumericInput(sc, "Introduzca el primer número:");
                    num2 = getNumericInput(sc, "Introduzca el segundo número:");
                    result = module(num1, num2);
                    operation = "resto";
                    break;
                case "6":
                    num1 = getNumberNonNegative(sc, "Introduzca el número:");
                    result = factorial((int) num1);
                    operation = "factorial";
                    break;
                case "7":
                case "s":
                case "S":
                    exit = true;
                    isOperation = false;
                    break;
                default:
                    isOperation = false;
                    break;
            }

            if (isOperation) {
                resultMessage = resultMsg(operation, num1, num2, result);
                System.out.println(resultMessage);
            }
        } while (!exit);

        System.out.println("El programa ha finalizado");
        sc.close();
    }

    /**
     * Calcula la suma de dos números
     *
     * @param num1 el primer número para sumar
     * @param num2 el segundo número para sumar
     * @return la suma de num1 y num2
     */
    private static float sum(float num1, float num2) {
        return num1 + num2;
    }

    /**
     * Resta dos números
     *
     * @param num1 el número del cual se va a restar el segundo número
     * @param num2 el número a restar de num1
     * @return la resta de num2 de num1
     */
    private static float subtract(float num1, float num2) {
        return num1 - num2;
    }

    /**
     * Multiplica dos números
     *
     * @param num1 el primer número a multiplicar
     * @param num2 el segundo número a multiplicar
     * @return la multiplicación de num1 y num2
     */
    private static float multiply(float num1, float num2) {
        return num1 * num2;
    }

    /**
     * Divide dos números
     *
     * @param num1 el número que se va a dividir
     * @param num2 el número por el cual se va a dividir num1
     * @return la división de num1 entre num2
     */
    private static float divide(float num1, float num2) {
        return num1 / num2;
    }

    /**
     * Calcula el módulo de dos números
     *
     * @param num1 el número del cual se va a calcular el módulo
     * @param num2 el número que se utilizará para calcular el módulo de num1
     * @return el módulo de num1 y num2
     */
    private static float module(float num1, float num2) {
        return num1 % num2;
    }

    /**
     * @param num1 número del que se quiere calcular el factorial
     * @return double resultado del factorial
     */
    private static float factorial(int num1) {
        int result = 1;
        for (int i = 1; i <= num1; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Muestra el menú de opciones y si la opción introducida es válida la devuelve
     *
     * @return String
     */
    private static String menu(Scanner sc) {
        String option;
        do {
            System.out.println("Introduzca una opción del menu:");
            System.out.println("1. Sumar(+)");
            System.out.println("2. Restar(-)");
            System.out.println("3. Multiplicar(*)");
            System.out.println("4. Dividir(/)");
            System.out.println("5. Resto(%)");
            System.out.println("6. Factorial(!)");
            System.out.println("7. Salir (S o s)");
            System.out.println("Introduzca una opción:");
            option = sc.next();
            if (!isValidOption(option)) {
                System.out.println("Opción no válida");
            }
        } while (!isValidOption(option));
        return option;
    }

    /**
     * Verifica si la opción proporcionada es válida para el programa.
     *
     * @param option la opción proporcionada por el usuario.
     * @return verdadero si la opción es válida, falso si no lo es.
     */
    private static boolean isValidOption(String option) {
        switch (option) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "s":
            case "S":
                return true;
            default:
                return false;
        }
    }

    /**
     * Verifica si una opción de entrada dada corresponde a una operación de un solo número.
     */
    private static boolean isOneNumberOperation(String option) {
        switch (option) {
            case "6":
            case "factorial":
                return true;
            default:
                return false;
        }
    }

    /**
     * Este método recibe una cadena que representa la operación realizada, dos números y el resultado de la operación,
     * y devuelve una cadena formateada que contiene el mensaje de resultado. El mensaje de resultado incluye la operación
     * ejecutada (suma, resta, multiplicación, división, resto o factorial), los dos números(en el caso de las operaciones
     * que requieren dos números) o el número (en el caso de la operación factorial) y el resultado
     * de la operación.
     *
     * @param operationString una cadena que representa la operación realizada
     * @param num1            el primer número ingresado por el usuario
     * @param num2            el segundo número ingresado por el usuario (solo se usa para operaciones que requieren dos números)
     * @param result          el resultado de la operación realizada
     * @return una cadena formateada que contiene el mensaje de resultado
     */
    private static String resultMsg(String operationString, float num1, float num2, float result) {
        String bar = "=============================================================";
        if (isOneNumberOperation(operationString))
            return bar + "\n" + "El resultado de la " + operationString + " de " + (int) num1 + " es " + (int) result
                    + "\n" + bar;
        else
            return bar + "\n" + "El resultado del " + operationString + " de " + num1 + " y " + num2 + " es " + result
                    + "\n" + bar;
    }

    /**
    
    Obtiene un valor numérico ingresado por el usuario a través del objeto Scanner.
    @param input objeto Scanner utilizado para obtener la entrada del usuario.
    @param message mensaje que se muestra al usuario para solicitar la entrada.
    @return valor numérico ingresado por el usuario.
    
    @see java.util.Scanner
    */
    public static float getNumericInput(Scanner input, String message) {
        float num;
        System.out.println(message);
        num = Float.parseFloat(input.next());
        return num;
    }

    /**
    
    Obtiene un valor numérico y se asegura que el valor devuelto sea no negativo, es ingresado por el usuario a través del objeto Scanner.
    @param input objeto Scanner utilizado para obtener la entrada del usuario.
    @param message mensaje que se muestra al usuario para solicitar la entrada.
    @return valor numérico no negativo ingresado por el usuario.
    
    @see java.util.Scanner
    */
    public static float getNumberNonNegative(Scanner input, String message) {
        float num;
        do {
            num = getNumericInput(input, message);
            if ((float) 0 > num) {
                System.out.println("El número debe ser positivo");
            }
        } while ((float) 0 > num);
        return num;
    }

    /**
    
    Obtiene un valor numérico y se asegura que el valor devuelto no sea 0, es ingresado por el usuario a través del objeto Scanner proporcionado.
    @param input objeto Scanner utilizado para obtener la entrada del usuario.
    @param message mensaje que se muestra al usuario para solicitar la entrada.
    @return valor numérico distinto de cero ingresado por el usuario.
    
    @see java.util.Scanner
    */
    public static float getNumberNonZero(Scanner input, String message) {
        float num;
        do {
            num = getNumericInput(input, message);
            if ((float) 0 == num) {
                System.out.println("El número debe ser distinto de cero");
                System.out.println("Introduzca un número distinto de cero");
            }
        } while ((float) 0 == num);
        return num;
    }
}
