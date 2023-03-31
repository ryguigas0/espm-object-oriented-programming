package aula5.models.classes.conta;

import aula5.models.interfaces.conta.ContaComLimite;

public class ContaPoupanca extends Conta implements ContaComLimite {

    private double limite;

    public ContaPoupanca(String agencia) {
        super(agencia);
    }

    @Override
    public double getLimite() {
        return this.limite;
    }

    @Override
    public void setLimite(double valor) {
        this.limite = valor;
    }
}
