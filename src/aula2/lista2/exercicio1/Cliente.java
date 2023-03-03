package aula2.lista2.exercicio1;

import aula2.lista2.Gerador;

public class Cliente {
    private String nome;
    private String cpf;
    private CartaoCredito cartaoCredito;
    private String numeroConta;
    private double saldo = 0;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.cartaoCredito = new CartaoCredito();
        this.numeroConta = "" + Gerador.numeroAleatorio(4);
    }

    public String retornarDados() {
        return String.format(
                "{ cpf: \"%s\", nome: \"%s\", numeroConta: \"%s\", saldo: \"R$%.2f\" , cartaoCredito: %s}",
                cpf, nome, numeroConta, saldo, cartaoCredito.retornarDados());
    }
}
