package aula2.exemplo1;

public class Main {
    public static void main(String[] args) {
        Conta c = new Conta();

        c.depositar(0);
        c.depositar(1000);
        c.sacar("2000");
        c.sacar(1000);
        c.setId("PF0001");
        System.out.println(c.getSaldo());
        System.out.println(c.getId());

        Monitoramento m = new Monitoramento();

        m.cobrarJurosDiario(c);
        System.out.println(c.getSaldo());

    }
}