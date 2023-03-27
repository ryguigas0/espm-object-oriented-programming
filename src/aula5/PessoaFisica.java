package aula5;

public class PessoaFisica extends Cliente {

    private String cpf;

    public PessoaFisica(String nome, String cpf) {
        super(nome);

        this.cpf = cpf;
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
