package aula3.exemplo1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<Cliente>();

        // clientes.add(new Cliente("Roberto"));
        clientes.add(new PessoaFisica("Roberto", "239.571.040-76"));

        // clientes.add(new Cliente("Jonathan",
        // "50c1403b-8e07-4dc5-a034-f5e44ecff2b9"));
        clientes.add(new PessoaFisica("Jonathan", "239.571.040-76",
                "50c1403b-8e07-4dc5-a034-f5e44ecff2b9"));

        clientes.add(new PessoaJuridica("Humberto Software House", "04.990.605/0001-28"));
        clientes.add(new PessoaJuridica("Guilherme Softworks", "61.771.065/0001-25"));

        System.out.println(clientes);
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getId() + " -> " + cliente.getNome());
            if (cliente instanceof PessoaFisica) {
                PessoaFisica pf = (PessoaFisica) cliente;
                System.out.println(cliente.getId() + " -> " + cliente.getNome() + " - " + pf.getCpf());
            } else if (cliente instanceof PessoaJuridica) {
                PessoaJuridica pj = (PessoaJuridica) cliente;
                System.out.println(cliente.getId() + " -> " + cliente.getNome() + " - " + pj.getCnpj());
            }
        }
    }
}
