package aula6;

public class Main {
    public static void main(String[] args) {
        try {
            int x = 200;
            int y = 0;

            int z = x / y; // Quebra o código porque, inteiros não podem ser divididos por 0

            System.out.println(x + "/" + y + " = " + z);

            perigoso();
        } catch (ArithmeticException e) {
            System.out.println("PEGA ARITHMETIC");
        } catch (RuntimeException re) {
            System.out.println("PEGA RUNTIME");
        } catch (Exception e) {
            System.out.println("PEGA TUDO");
        }
    }

    public static void perigoso() throws ExcecaoExemplo {
        throw new ExcecaoExemplo();
    }
}
