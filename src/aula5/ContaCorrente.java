package aula5;

public class ContaCorrente extends Conta implements ContaComLimite {

    private double limite;

    public ContaCorrente(String agencia) {
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
