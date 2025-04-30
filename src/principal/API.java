package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import enderecos.Endereco;
import enderecos.EnderecoCEP;

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
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String resp = response.body();
//        System.out.println(resp);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        EnderecoCEP enderecoCEP = gson.fromJson(resp, EnderecoCEP.class);
//        System.out.println("Objeto convertido: " + enderecoCEP);

        Endereco endereco = new Endereco(enderecoCEP.logradouro(), enderecoCEP.bairro(), enderecoCEP.localidade(), enderecoCEP.uf());

        System.out.println("Objeto convertido: " + endereco);

    }
}
