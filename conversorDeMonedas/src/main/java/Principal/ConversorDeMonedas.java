/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Principal;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author elizabeth.lavenant@dominio.semarnat.gob.mx
 */
public class ConversorDeMonedas {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        String[] monedas = {"ARS", "BOB", "BRL", "CLP", "COP", "MXN"};
        List<String> listaMonedas = Arrays.asList(monedas);
        Scanner lectura = new Scanner(System.in);
        int continuar = 100;
        while (continuar != 1 && continuar != 0){
            System.out.println("Bienvenido a nuestro conversor de monedas. Para continuar, presiona 1. Para salir, presiona 0.");
            continuar = lectura.nextInt();

            while ( continuar == 1 ){

                System.out.println("""
                                   1. D\u00f3lar a Peso argentino 
                                   2. D\u00f3lar a Bol\u00edvar boliviano
                                   3. D\u00f3lar a Real brasile\u00f1o 
                                   4. D\u00f3lar a Peso chileno
                                   5. D\u00f3lar a Peso colombiano 
                                   6. D\u00f3lar a Peso mexicano""");

                System.out.println("Digita el número de la conversión que deseas hacer: ");
                var numero = lectura.nextInt();
                var busqueda = listaMonedas.get(numero - 1);

                String direccion2 = "https://v6.exchangerate-api.com/v6/3ca581d7cefbfc01b2716375/pair/USD/" + busqueda;

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion2))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                var json = response.body();
                System.out.println(response.body());

                Gson gson = new Gson();
                Conversion miConversion = gson.fromJson(json, Conversion.class);
                System.out.println("El costo de un dólar es de " + miConversion.getConversion_rate() + " " + miConversion.getTarget_code());
                System.out.println("Para continuar, presiona 1. Para salir, presiona 0.");
                continuar = lectura.nextInt();

            } 
        }
        
        System.out.println("Gracias por utilizar nuestro conversor de monedas. ¡Hasta pronto!");
        
        
    }
}
