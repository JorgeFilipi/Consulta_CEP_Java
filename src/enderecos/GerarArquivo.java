package enderecos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GerarArquivo {
    public void salvaJson(Endereco endereco) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fw = new FileWriter(endereco.getCep() + ".json");
        fw.write(gson.toJson(endereco));
        fw.close();
    }
}
