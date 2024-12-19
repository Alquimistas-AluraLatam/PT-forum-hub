# Fórum Hub - Challenge Back-end do Programa ONE

## Descrição do projeto

O Fórum Hub é a implementação de uma API Rest utilizando Java e Spring onde a aplicação é um fórum regular com tópicos e respostas relacionadas a cursos. 

Neste caso, é uma aplicação que replica, de forma mais simples, o fórum que temos na plataforma Alura, que usamos conforme estudamos via cursos etc. 

Focamos nos tópicos neste projeto, ou seja, na criação, consulta, atualização e eliminação dos tópicos - o famoso CRUD (*Create, Read, Update and Delete*) que temos em projetos *backend*. 

### Curso do challenge

Para mais informações sobre o Fórum Hub, acesso o [curso do challenge](https://cursos.alura.com.br/course/spring-framework-challenge-forum-hub), que também possui o quadro trello do challenge.

## Estrutura do projeto

Este projeto foca na implementação de entidades que compõe tópicos, respostas, cursos e usuários, replicando assim o típico fórum que temos contato de acordo com algum curso ou tecnologia etc. Esta aplicação é uma construção de um API Rest com algumas funcionalidades que vimos na formação de Java e Spring Boot.

Nesta implementação, também trabalhamos a persistência de dados em um banco de dados relacional chamado MySQL, juntamente com a construção das tabelas do banco feitas utilizando migrações (ou *migrations*) e a dependência do Flyway. 

Além disso, tratamos da segurança da nossa aplicação implementando uma autenticação de usuários, em outras palavras, apenas usuários autorizados podem criar tópicos, responder tópicos ou criar cursos etc. 

E por fim, tratamos da documentação da nossa API do Fórum Hub, utilizando do Swagger e a dependência SpringDoc. 

### Branches

Organizamos o projeto em três *branches* (ramos) neste repositório: master (principal), security (segurança) e springdoc (documentação). E reforçarmos que a parte de documentação é um requisito OPCIONAL conforme sinalizado no quadro trello.

## Tecnologias utilizadas

- Java - versão 17: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

- Maven - versão 4.0.0 

- Spring - versão 3.2.5: https://start.spring.io/

- MySQL - versão 8.0: https://dev.mysql.com/downloads/

- Intellij Community (opcional): https://www.jetbrains.com/idea/download

- Dependências do Spring usadas:

  - Lombok

  - Spring Web
  - Spring Boot DevTools
  - Spring Data JPA
  - Flyway Migration
  - MySQL Driver
  - Validation
  - Spring Security

## Persistência de Dados

Reforçamos que ao utilizar *migrations* apenas necessitamos de criar o banco de dados antes de executar o projeto, e assim as *migrations* que construímos geram as tabelas e inserem dados. 

A ideia é que todo código SQL significativo para o projeto deve ser executado via *migration* e assim permitindo a pessoa desenvolvedora manter um histórico das mudanças na persistência dos dados do seu projeto. 

## Autenticação de Usuários

Neste projeto utilizamos do Spring Security (dependência do Spring) para manejar a parte de segurança e autenticação da aplicação, além disso, utilizamos do JWT para gerar tokens de autenticação de usuários. 

Então reforçamos que para testar o projeto é necessário autenticar usuários que estão presentes no banco de dados, **sugerimos primeiro inserir os usuários no banco com a senha encriptada** para então realizar a execução do projeto e autenticação do usuário com o token devidamente gerado.

Quando estiver com os usuários inseridos em seu banco de dados local, pode prosseguir para a execução da aplicação.

## Como executar o projeto

Para executar este projeto localmente, basta criar o arquivo .jar do projeto Java. Para gerar um arquivo JAR (Java ARchive) de um projeto Java, você pode seguir diferentes métodos, dependendo das ferramentas e ambientes de desenvolvimento que estiver usando.

Aqui estão os passos básicos para gerar um JAR usando ferramentas comuns como a linha de comando e IDEs como Eclipse e IntelliJ IDEA.

### **Usando a Linha de Comando (javac e jar)**

- **Compile seu código:** Navegue até o diretório onde está seu código-fonte e compile os arquivos .java para .class usando o comando javac:

```bash
javac -d out src/com/seuProjeto/*.java
```

Neste exemplo, os arquivos .java estão na pasta `src/com/seuProjeto` e os arquivos .class gerados serão colocados na pasta `out`.

- **Crie o arquivo JAR:** Use o comando jar para criar o arquivo JAR a partir dos arquivos .class compilados:

```bash
jar cvf meuProjeto.jar -C out .
```

Este comando cria um arquivo JAR chamado `meuProjeto.jar`, contendo todos os arquivos .class do diretório `out`.

### **Usando o Eclipse**

1. Exportar como JAR:
   - Clique com o botão direito no projeto na aba **Project Explorer**.
   - Selecione **Export** e depois **Java > JAR file**.
   - Escolha os recursos que deseja exportar e o local para salvar o arquivo JAR.
   - Configure as opções de exportação conforme necessário e clique em **Finish**.

### **Usando o IntelliJ IDEA**

1. **Criar Artefato:**
   - Acesse **File > Project Structure**.
   - Na aba **Artifacts**, clique em **+** e selecione **JAR > From modules with dependencies**.
   - Escolha o módulo principal do seu projeto e configure as opções conforme necessário.
   - Clique em **OK** e depois em **Apply**.
2. **Construir o Artefato:**
   - Acesse **Build > Build Artifacts** e selecione o artefato criado.
   - Clique em **Build** para gerar o arquivo JAR.

Também é possível adicionar ferramentas de construção como **Maven** e **Gradle** ao projeto e criar o arquivo .jar usando essas ferramentas.

## Autores

- Instrutor Eric Monné: https://www.linkedin.com/in/ericmonnefo/
- Monitora Brenda Souza: https://www.linkedin.com/in/breudes/
