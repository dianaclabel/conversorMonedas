package com.aluracursos.conversorDeMonedas.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ConsultarCambio {

        public BaseDeConversionExchangeRate consultarCambioApi( List<String> nombreDeMonedas ) {

            String endpoint = "https://v6.exchangerate-api.com/v6/af51492ae4d942db73f09ff1/pair/"+nombreDeMonedas.get(0)+"/"+nombreDeMonedas.get(1);

            System.out.println(endpoint);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .build();


            Gson gson = new GsonBuilder().setPrettyPrinting().create();




            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.body());
               return gson.fromJson(response.body(), BaseDeConversionExchangeRate.class);


            } catch (Exception  e) {
                throw new RuntimeException("Esa opcion aun no esta disponible");
            }
        };


}
