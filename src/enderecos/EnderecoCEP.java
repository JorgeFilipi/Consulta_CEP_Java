package enderecos;

public record EnderecoCEP(String cep,
                          String logradouro,
                          String numero,
                          String bairro,
                          String localidade,
                          String uf) {
}

