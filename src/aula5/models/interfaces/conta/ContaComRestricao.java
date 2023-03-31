package aula5.models.interfaces.conta;

public interface ContaComRestricao {
    public double getLimiteSaque();
    public void setLimiteSaque(double limite);
    public double getLimiteDeposito();
    public void setLimiteDeposito(double limite);
}
