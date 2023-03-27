package aula5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Banco {

    private String nome;
    private String agencia;

    private Map<String, Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        this.agencia = gerarNumeroAgencia();
        clientes = new HashMap<String, Cliente>();
    }

    private String gerarNumeroAgencia() {
        Random r = new Random();

        String output = "";

        for (int i = 0; i < 5; i++) {
            output += r.nextInt(9);
        }

        return output;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNome() {
        return nome;
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

}
