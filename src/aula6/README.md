# Aula 6 - Tratamento de exceções

## O que são exceções

Exceções são usadas para o programador limitar a forma de como o código pode ser utilizado

- Ex.: Se uma função tem argumentos que são vitais o programador pode colocar exceções para valores inválidos desses argumentos

## Como tratar exceções

```java
try {
    // Rode esse código, se houver uma exceção rode o catch correspondente
}catch (Exception e){ 
    // Todas exceções herdam da classe Exception
    // O que é pra fazer em relação a essa exceção específica
} finally {
    // Roda não importa se houve ou não erros
    // Ex.: fecha a conexão do banco de dados, dando certo ou errado
}
// Código pós tratamento
```

## Implementando a sua exceções

```java
// Para criar a exceção é necessário extender a classe Exception
// ExcecaoExemplo.java
public class ExcecaoExemplo extends Exception{
    @Override
    public String getMessage() {
        return "Erro inesperado";
    }
}

// Força quem for chamar a função fazer try-catch
// Main.java
public static void perigoso() throws ExcecaoExemplo {
    throw new ExcecaoExemplo();
}
```
