package aula3.exemplo1;

public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica(String nome, String cpf) {
        super(nome);

        this.cpf = cpf;
    }

    public PessoaFisica(String nome, String cpf, String id) {
        super(nome);

        this.cpf = cpf;
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return String.format("{nome: \"%s\", cpf: \"%s\", id: \"%s\"}",
                this.nome, this.cpf, this.id);
    }

}
