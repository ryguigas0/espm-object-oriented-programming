package aula2.lista2.exercicio2;

public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente("Guilherme", "12345678912");

        c.getConta().depositarSaldo(300);
        System.out.println(c);

        c.getConta().sacarSaldo(200);
        System.out.println(c);
    }
}
