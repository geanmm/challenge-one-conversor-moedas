package br.edu.gean.converter.models;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.text.MessageFormat;

public class Converter {
    public void convertCurrency(String entryCurrency, String outputCurrency, double value ){

        String key = "5a7b6f6c161c37d6fb926b79";
        String query =  key + "/pair/" + entryCurrency + "/" + outputCurrency + "/" + value;

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + query);

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();


            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Currency result = new Gson().fromJson(response.body(), Currency.class);

            DecimalFormat formatter = new DecimalFormat("#,##0.00");

            String output = MessageFormat.format("\n[ O valor de {0}{4} ({2}){1} corresponde a {0}{5} ({3}){1} ]\n",
            Color.cyan,Color.reset, entryCurrency, outputCurrency, formatter.format(value), formatter.format(result.conversion_result()));

            System.out.println(output);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro: Não foi possivel realizar a conexão." + e.getMessage());
        } catch (Exception e){
            throw new RuntimeException("Erro Inesperado: " + e.getMessage());
        }



    }
}
