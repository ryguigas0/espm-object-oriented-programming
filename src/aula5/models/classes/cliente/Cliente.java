package aula5.models.classes.cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import aula5.models.classes.conta.Conta;

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

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public Conta findConta(String numeroConta){
        for (Conta conta : this.contas) {
            if (conta.getNumero().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

}
