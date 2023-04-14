# Aula 7 - Iniciando com Springboot

## Acessando

- [Pela web](https://start.spring.io/)
- [Por extensão](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

## Configurando

- `Group`: endereço reverso da organização responsável pelo projeto (Ex.: br.espm.tech)
- `Artifact`: identificação do projeto na organização
- `Name`: nome do projeto
- `Description`: descrição do projeto
- `Package name`: pacote que vai colocar os arquivos do projeto
- `Packaging`: determina o que vai ser exportado
  - `Jar`: somente backend
  - `War`: backend + frontend
- `Java`: qual versão do Java vai ser usado (Usar mais próxima ou LTS)

### Escolhendo pacotes

Configura o `pom.xml` com as dependências que o maven vai usar (Como o `package.json` do node)

- `Spring Web`: Aplicações REST
- `Spring Data JPA`: Conectar com bancos de dados
- `MySQL Driver`: Conector com o banco de dados MySQL

## Colocando uma rota

1. Crie o arquivo `src/main/java/br/espm/tech/projeto/HelloResource.java`
2. Coloque a classe abaixo no arquivo

  ```java
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class HelloResource {

        @GetMapping("/ola")
        public String get() {
            return "Ola mundo!";
        }
    }
  ```

## Rodando

1. Rodar `mvn clean install`
2. Rodar `java -jar target/projeto-0.0.1-SNAPSHOT.jar`
