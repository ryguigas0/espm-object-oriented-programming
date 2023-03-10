package aula3.exemplo1;

public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String cnpj) {
        super(nome);

        this.cnpj = cnpj;
    }

    public PessoaJuridica(String nome, String cnpj, String id) {
        super(nome, id);

        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return String.format("{nome: \"%s\", cnpj: \"%s\", id: \"%s\"}",
                this.nome, this.cnpj, this.id);
    }
}
