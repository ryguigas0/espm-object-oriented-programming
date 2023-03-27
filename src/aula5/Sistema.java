package aula5;

import java.util.Scanner;

public class Sistema {

    private Scanner kb = new Scanner(System.in);
    private Banco banco;
    private Cliente clienteSelecionado;

    public void inicializar() {
        setup();
        loop();
    }

    private void setup() {
        System.out.print("Digite o nome do banco: ");
        String nomeBanco = kb.nextLine();

        banco = new Banco(nomeBanco);
    }

    private void loop() {
        System.out.println(String.format("Seja bem-vindo ao sistema automatizado do banco %s!", banco.getNome()));
        System.out.println("Digite 'help' para ver a lista de comandos disponíveis");

        boolean alive = true;

        do {
            String prefix = "> ";

            if (clienteSelecionado != null) {
                prefix = clienteSelecionado.getNome() + prefix;
            }

            System.out.print(prefix);
            String input = kb.nextLine().toLowerCase().trim();
            try {
                switch (input) {
                    case "help":
                        System.out.println("exit -> Finalizar a sessão atual");
                        System.out.println("new customer -> Cria um novo cliente");
                        System.out.println("list customer -> Lista os clientes cadastrados");
                        System.out.println("use customer -> Seleciona um cliente para fazer operações");
                        break;
                    case "exit":
                        System.out.println("Finalizando...");
                        alive = false;
                        break;
                    case "new customer":
                        addCustomer();
                        break;
                    case "list customer":
                        listCustomers();
                        break;
                    case "use customer":
                        selectCustomers();
                        break;
                    case "add conta":
                        if (clienteSelecionado == null) {
                            throw new RuntimeException("Nenhum cliente foi selecionado!");
                        }
                        addConta();
                        break;
                    default:
                        System.out.println("Comando não conhecido!");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (alive);
    }

    private void addConta() {
        //TODO: Acabar implementação do método
    }

    private void selectCustomers() {
        System.out.print("Digite o id do cliente: ");
        String id = kb.nextLine().trim();
        if (banco.getClientes().containsKey(id)) {
            clienteSelecionado = banco.getClientes().get(id);
        } else {
            throw new RuntimeException("Usuário não encontrado a partir do ID: " + id);
        }
    }

    private void addCustomer() {
        System.out.print("Cliente físico ou jurídico? [F/J] ");
        String input = kb.nextLine().toLowerCase();
        String nome = "";
        switch (input) {
            case "f":
                System.out.print("Digite o nome da pessoa física: ");
                nome = kb.nextLine();
                System.out.print("Digite o CPF da pessoa física: ");
                String cpf = kb.nextLine();
                PessoaFisica pf = new PessoaFisica(nome, cpf);
                banco.getClientes().put(pf.id, pf);
                break;
            case "j":
                System.out.print("Digite o nome da pessoa jurídica: ");
                nome = kb.nextLine();
                System.out.print("Digite o CNPJ da pessoa jurídica: ");
                String cnpj = kb.nextLine();
                PessoaFisica pj = new PessoaFisica(nome, cnpj);
                banco.getClientes().put(pj.id, pj);
                break;
            default:
                throw new RuntimeException("Entrada de dado inválida");
        }
    }

    private void listCustomers() {
        System.out.println("ID - NOME - CPF/CNPJ");
        banco.getClientes().forEach((id, cliente) -> {
            if (cliente instanceof PessoaFisica pf) {
                System.out.println(cliente.id + " - " + cliente.nome + " - " + pf.getCpf());
            } else if (cliente instanceof PessoaJuridica pj) {
                System.out.println(cliente.id + " - " + cliente.nome + " - " + pj.getCnpj());
            }
        });
    }
}
