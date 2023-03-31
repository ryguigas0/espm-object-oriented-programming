package aula5;

import java.util.Scanner;

import aula5.models.classes.banco.Banco;
import aula5.models.classes.cliente.Cliente;
import aula5.models.classes.cliente.PessoaFisica;
import aula5.models.classes.cliente.PessoaJuridica;
import aula5.models.classes.conta.Conta;
import aula5.models.classes.conta.ContaCorrente;
import aula5.models.classes.conta.ContaPoupanca;
import aula5.models.classes.conta.ContaSalario;

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
                        System.out.println("add conta -> Operação de adicionar conta de cliente");
                        System.out.println("list conta -> Operação de listar as contas de um cliente");
                        System.out.println("deposit conta -> Operação de depositar saldo de uma conta do cliente");
                        System.out.println("withdraw conta -> Operação de sacar saldo de uma conta do cliente");
                        break;
                    case "exit":
                        System.out.println("Finalizando...");
                        alive = false;
                        break;
                    case "new customer":
                        addCliente();
                        break;
                    case "list customer":
                        listClientes();
                        break;
                    case "use customer":
                        selectClientes();
                        break;
                    case "add conta":
                        addConta();
                        break;
                    case "list conta":
                        listContas();
                        break;
                    case "deposit conta":
                        depositarConta();
                        break;
                    case "withdraw conta":
                        // sacarConta();
                        throw new RuntimeException("Comando não implementado!");
                    // break;
                    default:
                        System.out.println("Comando não conhecido! Digite 'help' para mostrar todos os comandos");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (alive);
    }

    private void depositarConta() {
        System.out.print("Digite o numero da conta: ");
        String numeroConta = kb.nextLine().trim();

        Conta conta = clienteSelecionado.findConta(numeroConta);

        if (conta == null) {
            throw new RuntimeException("Conta não foi encontrada!");
        }

        System.out.print("Digite o valor para depositar: R$");
        double depoisto = kb.nextDouble();

        conta.depositar(depoisto);
    }

    private void addConta() {
        if (clienteSelecionado == null) {
            throw new RuntimeException("Nenhum cliente foi selecionado!");
        }

        System.out.print("A conta é do tipo Corrente, Poupanca ou Salario? [C/P/S] ");
        String tipoConta = kb.nextLine().toLowerCase().trim();

        Conta novaConta = null;
        String numAgencia = banco.getAgencia();

        if (tipoConta.equals("c")) {
            novaConta = new ContaCorrente(numAgencia);
        } else if (tipoConta.equals("p")) {
            novaConta = new ContaPoupanca(numAgencia);
        } else if (tipoConta.equals("s")) {
            novaConta = new ContaSalario(numAgencia, 1000.0, 1000.0);
        } else {
            throw new RuntimeException("Opção de conta inválida!");
        }

        clienteSelecionado.addConta(novaConta);
    }

    private void listContas() {
        if (clienteSelecionado == null) {
            throw new RuntimeException("Nenhum cliente foi selecionado!");
        }
        System.out.println("AGENCIA - NUMERO - SALDO - LIMITE");
        String output = "";
        for (Conta conta : clienteSelecionado.getContas()) {
            if (conta instanceof ContaCorrente cc) {
                output = String.format("%s - %s - %s - R$%.2f", cc.getAgencia(),
                        cc.getNumero(), cc.getSaldo(), cc.getLimite());
            } else if (conta instanceof ContaPoupanca cp) {
                output = String.format("%s - %s - %s - R$%.2f", cp.getAgencia(),
                        cp.getNumero(), cp.getSaldo(), cp.getLimite());
            } else if (conta instanceof ContaSalario cs) {
                output = String.format("%s - %s - %s - Saque: R$%.2f / Deposito: R$%.2f", cs.getAgencia(),
                        cs.getNumero(), cs.getSaldo(), cs.getLimiteSaque(), cs.getLimiteDeposito());
            }
        }
        System.out.println(output);
    }

    private void selectClientes() {
        System.out.print("Digite o id do cliente: ");
        String id = kb.nextLine().trim();
        if (banco.getClientes().containsKey(id)) {
            clienteSelecionado = banco.getClientes().get(id);
        } else {
            throw new RuntimeException("Usuário não encontrado a partir do ID: " + id);
        }
    }

    private void addCliente() {
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
                banco.getClientes().put(pf.getId(), pf);
                break;
            case "j":
                System.out.print("Digite o nome da pessoa jurídica: ");
                nome = kb.nextLine();
                System.out.print("Digite o CNPJ da pessoa jurídica: ");
                String cnpj = kb.nextLine();
                PessoaFisica pj = new PessoaFisica(nome, cnpj);
                banco.getClientes().put(pj.getId(), pj);
                break;
            default:
                throw new RuntimeException("Entrada de dado inválida");
        }
    }

    private void listClientes() {
        System.out.println("ID - NOME - CPF/CNPJ");
        banco.getClientes().forEach((id, cliente) -> {
            if (cliente instanceof PessoaFisica pf) {
                System.out.println(cliente.getId() + " - " + cliente.getNome() + " - " + pf.getCpf());
            } else if (cliente instanceof PessoaJuridica pj) {
                System.out.println(cliente.getId() + " - " + cliente.getNome() + " - " + pj.getCnpj());
            }
        });
    }
}
