package aula2.exemplo1;

public class Conta {
    private String id = null;

    private double saldo = 0.0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo - valor;
        }
    }

    public void sacar(String valorString) {
        double valor = Double.parseDouble(valorString);
        this.sacar(valor);
    }

    public void depositar(double valor) {
        if (valor > 0)
            this.saldo += valor;
    }
}
