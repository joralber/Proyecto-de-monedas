import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Procesos {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/98e8f9ddb11cacbe91a5e20c/latest/";
    private List<String> historial = new ArrayList<>();

    public double obtenerTasaDeCambio(String fromCurrency, String toCurrency) {
        try {
            URI uri = URI.create(API_URL + fromCurrency);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");

            return conversionRates.get(toCurrency).getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }

    public double convertirMoneda(String fromCurrency, String toCurrency, double cantidad) {
        double tasa = obtenerTasaDeCambio(fromCurrency, toCurrency);
        double resultado = cantidad * tasa;

        // Registro con marca de tiempo
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String registro = String.format("[%s] %.2f %s => %.2f %s", ahora.format(formato), cantidad, fromCurrency, resultado, toCurrency);

        // Agregar al historial
        agregarAlHistorial(registro);

        return resultado;
    }

    public void agregarAlHistorial(String conversion) {
        historial.add(conversion);
    }

    public void mostrarHistorial() {
        System.out.println("\n--- Historial de Conversiones ---");
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones realizadas aún.");
        } else {
            for (String registro : historial) {
                System.out.println(registro);
            }
        }
    }
}
