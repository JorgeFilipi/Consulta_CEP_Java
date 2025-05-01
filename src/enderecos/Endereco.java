package enderecos;

public class Endereco {
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;


    public Endereco(String cep, String logradouro, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "\n\tEndereço{" +
                "\n\t\tLogradouro: " + logradouro +
                "\n\t\tBairro: " + bairro +
                "\n\t\tCidade: " + cidade +
                "\n\t\tEstado: " + estado +
                "\n\t\t}";
    }

}


