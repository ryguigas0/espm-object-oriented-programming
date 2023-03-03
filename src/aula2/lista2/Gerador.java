package aula2.lista2;

import java.util.Random;

public class Gerador {
    public static int numeroAleatorio(int tamanho) {
        Random r = new Random();

        double numAleat = r.nextDouble() * Math.pow(10, tamanho);

        return (int) Math.floor(numAleat);
    }

    public static int numeroAleatorio(int tamanho, int maximo) {
        int numAleat = numeroAleatorio(tamanho);

        if (numAleat > maximo) {
            return maximo;
        } else {
            return numAleat;
        }
    }
}
