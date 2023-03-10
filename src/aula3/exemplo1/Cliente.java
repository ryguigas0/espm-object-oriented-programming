package aula3.exemplo1;

import java.util.UUID;

public abstract class Cliente {

    public String id;
    public String nome;

    public Cliente() {
    }

    public Cliente(String nomeCliente, String id) {
        this(nomeCliente);

        this.id = id;
    }

    public Cliente(String nomeCliente) {
        this.id = UUID.randomUUID().toString();
        this.nome = nomeCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

}
