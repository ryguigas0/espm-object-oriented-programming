# Aula 1
## Comparando Strings
```java
String a = "String";

String b = "String";

String c = "Str";
c = c + "ing";

// a == b => true
// 'a' e 'b' apontam para o mesmo endereço de memória (endr do valor "String" na Stack), logo são iguais
// a == c => false
// 'a' e 'c' apontam para memórias direferentes (endr do valor "String" e "Str" na Stack 
// e "ing" no Heap), logo são diferentes
// então use .equals (método herdado da classe Object)
// a.equals(c) => true

```

## Sobrescrevendo métodos
```java
    @Override // -> Sobrescreva o método abaixo (prof1.equals(obj))
    public boolean equals(Object obj) {
        // Para os objetos professor e obj serem iguais ...
        return (obj instanceof Professor)  // obj deve ser da mesma classe
            && ((Professor) obj).id.equals(this.id); // obj deve ter o mesmo id que o professor
    }

    // toString -> Como transforma o objeto em string
    // hashCode -> Como transforma o objeto em um int
```

## Lista x Sets
```java
    // Sets não repetem elementos
    Set<Integer> set = new HashSet<Integer>();
    set.add(1);
    set.add(2);
    set.add(3);
    set.add(4);
    set.add(4);
    // Elementos do set => 1, 2, 3 e 4

    // Listas repetem elementos
    List<Integer> lista = new ArrayList<Integer>();
    lista.add(1);
    lista.add(2);
    lista.add(3);
    lista.add(4);
    lista.add(4);
    // Elementos da lista => 1, 2, 3, 4 e 4

    Set objs = new HashSet<>(); // Set que aceita qualquer objeto
    objs.add(obj);
    objs.add(1);
    objs.add("Eu sou uma string!");
    // Elemetos do set => obj, 1 e "Eu sou uma string!"
```