# Aula 2 - Conceitos de class

## Público, privado e protegido

```java
    // public -> pode ser acessado por qualquer um
    // private -> só dá pra ser acessado pela própia
    // protected -> dá ser acessado apenas pelo próprio e no mesmo pacote, 
    //      forçando a ser acessado por métodos públicos / privados

    // BOA PRÁTICA: todas os atributos de classe devem ser protegidas e passar por um get ou set
```

## Atributos e Métodos

```java
// atributos -> camelCase
// constantes -> CONSTANTE_A

// public -> visibilidade
// static -> roda sem ser instanciado, logo sem oop -> vai no stack
// somar -> nome do método (verbos)
// a, b -> argumentos
// return a + b -> retorno
public static int somar(int a, int b) {
    return a + b;
}
// métodos static só podem acessar atributos static da classe

// por isso o main é o main
// BOA PRÁTICA: colocar constantes como static para todas as instâncias terem o mesmo
// EXEMPLO: Short.MAX_VALUE

public void metodo(o Objeto) {
    // sysout objeto
}
```

## Sobrecarga de métodos

```java
public int somar(int a, int b) {
    return a + b;
}

// Sobrecarga -> mesmo nome, argumentos com tipos diferentes
public int somar(String aString, String bString) {
    int a = Integer.parseInt(aString);
    int b = Integer.parseInt(bString);
    this.somar(a, b); // chama a implementação pra integers
}

// MÉTODOS CONSTRUTORES TAMBÉM PODEM SER SOBRECARREGADOS
```

## UUID

```java
    // UUID -> Universal Unique IDentifier -> ID único universal
    String uuid = UUID.randomUUID().toStirng(); // -> "4241d027-1c53-48e9-a1e8-01d9d449002c"
```
