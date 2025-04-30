package enderecos;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(String rua, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;


    }


    @Override
    public String toString() {
        return "\n\tEndereço{" +
                "\n\t\tLogradouro: " + rua +
                "\n\t\tBairro: " + bairro +
                "\n\t\tCidade: " + cidade +
                "\n\t\tEstado: " + estado +
                "\n\t\t}";
    }
}


