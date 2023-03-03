package aula2.lista2.exercicio2;

import aula2.lista2.Gerador;

public class Conta {
    private String numeroConta;
    private double saldo = 0;

    public Conta() {
        this.numeroConta = "" + Gerador.numeroAleatorio(4);
    }

    @Override
    public String toString() {
        return String.format("{ numeroConta: \"%s\", saldo \"R$%.2f\" }", numeroConta, saldo);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositarSaldo(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void sacarSaldo(double valor) {
        if (valor > 0) {
            this.saldo -= valor;
        }
    }

}
