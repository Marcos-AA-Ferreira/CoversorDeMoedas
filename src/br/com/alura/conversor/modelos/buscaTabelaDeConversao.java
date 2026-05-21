package br.com.alura.conversor.modelos;

import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class buscaTabelaDeConversao {

    //Acessa a Api pelos dados obtidos
    public opcoesDeConversao buscaOpcoes(String moedaParaConversao) {
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/********************/latest/" + moedaParaConversao);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();

            HttpResponse<String> response;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Houver um erro na obtenção dos dados" + e.getMessage());
        }

        //Eu tive um pouco de dificuldade nessa parte de extrair os dados que eu queria, então usei o chatGPT nessa parte.

        // Usa Gson para converter a resposta em um JsonObject
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

        // Extrai as taxas de conversão do JsonObject
        double usd = jsonObject.get("conversion_rates").getAsJsonObject().get("USD").getAsDouble();
        double ars = jsonObject.get("conversion_rates").getAsJsonObject().get("ARS").getAsDouble();
        double brl = jsonObject.get("conversion_rates").getAsJsonObject().get("BRL").getAsDouble();
        double cop = jsonObject.get("conversion_rates").getAsJsonObject().get("COP").getAsDouble();
        double eur = jsonObject.get("conversion_rates").getAsJsonObject().get("EUR").getAsDouble();

        // Cria uma instância do record usando os valores extraídos
        return new opcoesDeConversao(usd, ars, brl, cop, eur);

    }



}

