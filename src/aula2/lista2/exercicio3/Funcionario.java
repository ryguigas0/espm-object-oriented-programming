package aula2.lista2.exercicio3;

public class Funcionario {
    private String cpf;
    private String nome;
    private double salario;
    private double valeRefeicao = 550.0;

    public Funcionario(String cpf, String nome, double salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
    }

    public String retornarDados() {
        return String.format(
                "{ cpf: \"%s\", nome: \"%s\", salario: \"%.2f\", valeRefeicao: \"%.2f\"}",
                cpf, nome, salario, valeRefeicao);
    }

    public void aumentarSalario(double porcentagem) {
        this.salario = aumentarPercentual(this.salario, porcentagem);
    }

    public void ajustarValeRefeicao(double porcentagem) {
        this.valeRefeicao = aumentarPercentual(this.salario, porcentagem);
    }

    private double aumentarPercentual(double valor, double porcentagem) {
        return valor * (porcentagem + 100) / 100;
    }
}
