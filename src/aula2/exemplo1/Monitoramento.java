package aula2.exemplo1;

public class Monitoramento {

    private static double PORCENTAGEM_JUROS = 0.00385341040268316228498359873694;

    public void cobrarJurosDiario(Conta c) {
        double valorJuros = PORCENTAGEM_JUROS * c.getSaldo() * -1;
        c.sacar(valorJuros);
        System.err.println("JUROS SACADO AUTOMÁTICAMENTE");
    }
}
