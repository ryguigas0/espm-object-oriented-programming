package aula2.lista2.exercicio2;

import java.util.UUID;

public class Cliente {
    private String id;
    private String nome;
    private String cpf;
    private Conta conta;
    private CartaoCredito cartaoCredito;

    public Cliente(String nome, String cpf) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.cpf = cpf;
        this.cartaoCredito = new CartaoCredito();
        this.conta = new Conta();
    }

    @Override
    public String toString() {
        return String.format(
                "{ id: \"%s\", cpf: \"%s\", nome: \"%s\", conta: %s , cartaoCredito: %s}",
                id, cpf, nome, conta, cartaoCredito);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Conta getConta() {
        return conta;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }
}
