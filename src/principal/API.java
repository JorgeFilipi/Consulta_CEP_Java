package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import enderecos.Endereco;
import enderecos.EnderecoCEP;
import enderecos.GerarArquivo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class API {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um numero do CEP: ");
        String cep = sc.nextLine();

        var url = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String resp = response.body();
            Gson gson = new GsonBuilder().create();
            EnderecoCEP enderecoCEP = gson.fromJson(resp, EnderecoCEP.class);
            Endereco endereco = new Endereco(enderecoCEP.cep(),
                    enderecoCEP.logradouro(), enderecoCEP.bairro(),
                    enderecoCEP.localidade(), enderecoCEP.uf());

            System.out.println("Objeto convertido: " + endereco);
            GerarArquivo gerador = new GerarArquivo();
            gerador.salvaJson(endereco);

        } catch (RuntimeException | IOException e) {
            System.out.println("Erro de comunicação com a API: " + e.getMessage());

        }
    }
}
