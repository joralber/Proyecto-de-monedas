import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Procesos  service = new Procesos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 8) {
                System.out.print("Ingrese la cantidad: ");
                double cantidad = scanner.nextDouble();

                try {
                    double resultado;
                    switch (opcion) {
                        case 1 -> resultado = service.convertirMoneda("USD", "ARS", cantidad);
                        case 2 -> resultado = service.convertirMoneda("ARS", "USD", cantidad);
                        case 3 -> resultado = service.convertirMoneda("USD", "BRL", cantidad);
                        case 4 -> resultado = service.convertirMoneda("BRL", "USD", cantidad);
                        case 5 -> resultado = service.convertirMoneda("USD", "COP", cantidad);
                        case 6 -> resultado = service.convertirMoneda("COP", "USD", cantidad);
                        case 7 -> resultado = service.convertirMoneda("USD", "GBP", cantidad);
                        case 8 -> resultado = service.convertirMoneda("GBP", "USD", cantidad);
                        default -> throw new IllegalStateException("Opción inválida.");
                    }
                    System.out.println("Resultado: " + resultado);
                } catch (RuntimeException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (opcion == 9) {
                service.mostrarHistorial();
            } else if (opcion == 10) {
                System.out.println("¡Gracias por usar el Conversor de Monedas!");
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 10);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Conversor de Monedas ---");
        System.out.println("1. Dólar =>> Peso argentino");
        System.out.println("2. Peso argentino =>> Dólar");
        System.out.println("3. Dólar =>> Real brasileño");
        System.out.println("4. Real brasileño =>> Dólar");
        System.out.println("5. Dólar =>> Peso colombiano");
        System.out.println("6. Peso colombiano =>> Dólar");
        System.out.println("7. Dólar =>> Libra esterlina");
        System.out.println("8. Libra esterlina =>> Dólar");
        System.out.println("9. Ver historial de conversiones");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
