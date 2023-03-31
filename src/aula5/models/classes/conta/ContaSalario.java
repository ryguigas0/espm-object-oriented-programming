package aula5.models.classes.conta;

import aula5.models.interfaces.conta.ContaComRestricao;

public class ContaSalario extends Conta implements ContaComRestricao {

    double limiteSaque;
    double limiteDeposito;

    public ContaSalario(String agencia, double limiteSaque) {
        super(agencia);

        this.limiteSaque = limiteSaque;
    }

    @Override
    public double getLimiteSaque() {
        return this.limiteSaque;
    }

    @Override
    public void setLimiteSaque(double limite) {
        this.limiteSaque = limite;
    }

    @Override
    public double getLimiteDeposito() {
        return this.limiteDeposito;
    }

    @Override
    public void setLimiteDeposito(double limite) {
        this.limiteDeposito = limite;
    }

    @Override
    public void depositar(double deposito) {
        if (deposito > this.limiteDeposito) {
            throw new RuntimeException("Depósito acima do limite de " + this.limiteDeposito + " bloqueado!");
        }
        super.depositar(deposito);
    }

    @Override
    public void sacar(double saque) {
        if (saque > this.limiteSaque) {
            throw new RuntimeException("Saque acima do limite de " + this.limiteSaque + " bloqueado!");
        }
        super.sacar(saque);
    }

}
