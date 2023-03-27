package aula5;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Cliente {

    protected String id;
    protected String nome;
    private List<Conta> contas = new ArrayList<Conta>();

    public Cliente(String nome) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

}
