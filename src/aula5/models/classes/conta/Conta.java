package aula5.models.classes.conta;

import java.util.Random;
import java.util.UUID;

public abstract class Conta {
    private String id;
    private String agencia;
    private String numero;
    private double saldo = 0.0;

    public Conta(String agencia) {
        this.agencia = agencia;
        this.id = UUID.randomUUID().toString();
        this.numero = gerarNumeroConta();
    }

    private String gerarNumeroConta() {
        Random r = new Random();

        String output = "";

        for (int i = 0; i < 7; i++) {
            output += r.nextInt(9);
        }

        return output;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double deposito) {
        if (deposito < 0) {
            throw new RuntimeException("Valor de depósito inválido!");
        }

        this.saldo += deposito;
    }

    public void sacar(double saque) {
        if (saque < 0) {
            throw new RuntimeException("Valor de saque inválido!");
        }

        this.saldo -= saque;
    }

    public String getId() {
        return id;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

}
