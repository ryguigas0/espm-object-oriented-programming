package aula5;

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
