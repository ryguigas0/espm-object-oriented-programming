# Aula 3 - Herança

## Herança

- O cliente tem nome e id, mas há dois tipos de clientes, um com cpf e outro com cnpj

```java
// Cliente.java -> Características base dos clientes
public class Cliente {
    public String id;
    public String nome;

    // construtor vazio (remover obrigação de criar construtores nas classes filhas)
    public Cliente(){}

    // construtor que gera id automático omitido

    // construtor que recebe o id omitido

    // get e set id omitido

    // get e set nome omitido
}
```

```java
// PessoaJuridica.java -> Características do cliente + pessoa jurídica
public class PessoaJuridica extends Cliente { // Filha extends Mãe
    public String cnpj;

    public PessoaJuridica (String nome, String cnpj) {
        super(nome); // Chama o construtor da classe mãe -> Cliente(nome)

        this.cnpj = cnpj;
    }

    public PessoaJuridica (String nome, String cnpj, String id) {
        super(nome, id); // Chama o construtor da classe mãe -> Cliente(nome, id)

        this.cnpj = cnpj;
    }

    // HERDA os get e set de nome e id da classe Cliente

    // get e set cnpj omitido

    // toString omitido
}
```

```java
// PessoaFisica.java -> Características do cliente + pessoa física
public class PessoaFisica extends Cliente {
    public String cpf;

    public PessoaFisica (String nome, String cpf) {
        super(nome); // Chama o construtor da classe mãe -> Cliente(nome)

        this.cpf = cpf;
    }

    public PessoaFisica (String nome, String cpf, String id) {
        super(nome, id); // Chama o construtor da classe mãe -> Cliente(nome, id)

        this.cpf = cpf;
    }

    // HERDA os get e set de nome e id da classe Cliente

    // get e set cpf omitido

    // toString omitido
}
```

## Classes Abstratas

- Na regra do meu negócio, só tem cliente pessoa jurídica ou física, não só cliente

```java
// Cliente.java
public abstract class Cliente { // abstract -> Class abstrata -> NÃO PODE SER INSTANCIADA
    // ...
}
```

```java
// Main.java

public class Main{
    public static void main(String[] args) {
        // O tipo Cliente inclui PessoaFisica
        Cliente clienteFisico = new PessoaFisica("Roberto");
        // O tipo Cliente inclui PessoaJuridica
        Cliente clienteJuridico = new PessoaJuridica("Guilherme Softworks");
    }
}
```

## BÔNUS

### `for each`

```java
// Main.java
// ...
    List<Cliente> clientes = new ArrayList<Cliente>(); // Lista de clientes
// ...
    for (Cliente cliente : clientes) { // Para cada cliente na lista de clientes
        // Não tem como acessar dados de pessoa física ou pj sem separar
        if (cliente instanceof PessoaFisica) { 
            PessoaFisica pf = (PessoaFisica) cliente; // Precisa transformar o objeto
            System.out.println(cliente.getId() + " -> " + cliente.getNome() + " - " + pf.getCpf());
        } else if (cliente instanceof PessoaJuridica) {
            PessoaJuridica pj = (PessoaJuridica) cliente;
            System.out.println(cliente.getId() + " -> " + cliente.getNome() + " - " + pj.getCnpj());
        }
    }
// ...
```

### Relação master x detail

- Objetivo: Saber as notas fiscais emitidas
- NF: ID, Data, Hora -> Master
- ItemNF: IDNF, IDPRO (Chave composta), QTD -> Detail
- Produto: ID, Nome, Preco -> Master

- Objetivo: Saber a quantidade de um produto comprado
- NF: ID, Data, Hora -> Detail
- ItemNF: IDNF, IDPRO (Chave composta), QTD -> Master
- Produto: ID, Nome, Preco -> Detail

AVISO: NÃO USE CHAVES COMPOSTAS NA VIDA REAL PORQUE SE PRECISAR MUDAR
AS CONEXÕES DA TABELA VOCÊ NÃO CONSEGUE, VOCÊ ESTÁ REFÉM DA CONEXÃO. USE
UM ID AUTOGENERADO NÃO SEQUENCIAL NESSAS TABELAS

### Montando uma arquitetura com o java

- Objetivo: Criar sistemas separados que se conectam de forma que sejam independentes
- ClienteDTO: recebe JSON e manda para o ClienteBusiness e envia JSON para a requisição
- CLienteController: segurança entre o DTO e o Business e consome e responde e envia o JSON
- ClienteBusiness: regras de negócio para o controller decidir
- ClienteBean: objeto com todos os dados para o Business usar (usa uma lista de beans)
- ClienteDAO: faz a interface com o hibernate (assim o banco de dados) para interagir com o banco de dados
