package aula2.lista2.exercicio1;

import java.util.UUID;

import aula2.lista2.Gerador;

public class CartaoCredito {
    private String id;
    private String numerosFrente;
    private String cvv;
    private String dataExpiracao;

    public CartaoCredito() {
        this.id = UUID.randomUUID().toString();
        this.numerosFrente = "" + Gerador.numeroAleatorio(12);
        this.cvv = "" + Gerador.numeroAleatorio(3);
        this.dataExpiracao = String.format("%02d/%02d",
                Gerador.numeroAleatorio(2, 12),
                Gerador.numeroAleatorio(2, 99));
    }

    public String retornarDados() {
        return String.format(
                "{id:\"%s\" , numerosFrente: \"%s\", cvv: \"%s\", dataExpiracao: \"%s\"}",
                id, numerosFrente, cvv, dataExpiracao);
    }

}
