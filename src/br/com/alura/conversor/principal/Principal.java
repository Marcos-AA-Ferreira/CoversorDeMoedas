package br.com.alura.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String endereco;

        Scanner moeda = new Scanner(System.in);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


        } catch (NumberFormatException e) {

            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na buscar");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Aconteceu um erro");
        }
    }

}
}
