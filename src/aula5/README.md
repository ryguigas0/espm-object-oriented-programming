# Aula 6 - Interfacse

## Interfaces

```java
// contrato.java
public interface Arquivo { // Quem implementa a interface precisa definir os métodos abaixo
    public Autor getAutor();
    public Stirng getIdentifier();
}

// post.java
public interface Post extends Arquivo{ // Tem como interfaces extenderem outras interfaces
    public String getContent();
    public String setContent();
}

// noticia.java
public class Noticia implements Post {

    // ...

    public String getContent(){
        return this.contentHTML;
    }

    public Autor getAutor() {
        // ... -> Não importa como ele é implementado, importa que ele existe
        return autor.name;
    }
    public Autor getIdentifier() {
        // ... -> Não importa como ele é implementado, importa que ele existe
        return this.identifier;
    }
}

//livro.java
public class Livro implements Arquivo, Buscavel{ // Tem como implementar mais que uma interface
    // ...
}
```

## Bônus

### `.jar`

- Arquivos `.jar` são resultado da compilação e compactação de todas as classes envolvidas no projeto, incluindo depedências de código

### Microserviços

- Maior dificuldade: acertar quantos microsserviços são necessários
  - Não virar monolito: um serviço gigante com vários
  - Não virar uma teia gigante: microsserviços demais emaranhados
- Proporção: 1 microsserviço ~: 1 tabela no banco de dados
