# Aula 4 - Encapsulamento e Polimorfismo

## Polimorfismo

```java
// Main.java
public class Main {
    public static void main(String[] args) {
        // Uma PessoaFisica pode ser tratada como Cliente
        Cliente c = new PessoaFisica("Jonathan");
    }
}
```

## Encapsulamento

```java
// Conta.java
public class Conta {
    protected senhaSecreta = "123456";
}
```

```java
// Usuario.java
public class Usuario extends Conta {
    public String revelaSenha() {
        return senhaSecreta;
    }
}
```
