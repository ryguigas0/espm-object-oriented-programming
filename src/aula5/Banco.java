package aula5;

import java.util.HashMap;
import java.util.Map;

public class Banco {

    private String nome;

    private Map<String, Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        clientes = new HashMap<String, Cliente>();
    }

    public String getNome() {
        return nome;
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

}
