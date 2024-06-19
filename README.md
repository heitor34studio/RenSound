# RenSound
![Java Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![PostgreSQL Badge](https://img.shields.io/badge/PostgreSQL-232F3E?style=for-the-badge&logo=PostgreSQL&logoColor=white) ![Maven Badge](https://img.shields.io/badge/Maven-f24d38?style=for-the-badge&logo=Maven&logoColor=white) ![Spring Badge](https://img.shields.io/badge/Spring-59d141?style=for-the-badge&logo=Spring&logoColor=black)

O projeto RenSound é uma ferramenta que permite ao usuário cadastrar informações sobre músicas e artistas em seu próprio banco de dados. O usuário pode então listar as músicas cadastradas e buscar as músicas de um artista específico cadastrado.

## Índice 

* [Título e Descrição](#pesquisa-fipe)
* [Índice](#índice)
* [Funcionalidades do Projeto](#-funcionalidades-do-projeto)
* [Tecnologias Utilizadas](#%EF%B8%8F-técnicas-e-tecnologias-utilizadas)
* [Acesso ao Projeto](#-acesso-ao-projeto)
* [Abrir e Rodar o Projeto](#%EF%B8%8F-abrir-e-rodar-o-projeto)
* [Detalhamento do Código Java](#-detalhamento-do-código-java)

## 🔨 Funcionalidades do projeto

O RenSound oferece as seguintes funcionalidades:

- Cadastro de artista no DB.
- Cadastro de músicas no DB.
- Listagem de todas músicas cadastradas.
- Busca de músicas por artista.

## ✔️ Técnicas e tecnologias utilizadas

- `Java`: Linguagem principal utilizada no desenvolvimento do projeto.
- `Maven`: Ferramenta de gerenciamento de dependências e build.
- `Spring Framework`: Utilizado para facilitar a criação da aplicação.
- `JPA & PostgreSQL`: Dependências utilizadas para conexão com o DB e gerenciamento das tabelas e dos dados.

## 📁 Acesso ao projeto

Você pode acessar o código fonte do projeto [aqui](https://github.com/heitor34studio/RenSound/tree/main/RenSound/src/main/java/br/com/alura/RenSound).

## 🛠️ Abrir e rodar o projeto

Para abrir e rodar o projeto, siga os seguintes passos:

1. Clone o repositório para o seu ambiente local:
    ```sh
    git clone https://github.com/heitor34studio/RenSound.git
    ```

2. Navegue até o diretório do projeto:
    ```sh
    cd RenSound; cd src; cd main; cd java; cd br; cd com; cd alura; cd RenSound; 
    ```

3. Compile o projeto (RenSoundApplication.java) usando Maven:
    ```sh
    mvn clean install 
    ```

4. Execute o projeto:
    ```sh
    mvn spring-boot:run
    ```

### Detalhamento do código Java:

O código Java fornecido implementa um programa para cadastrar informações sobre músicas e artistas em seu próprio banco de dados.

#### Principal.java
Este arquivo contém a lógica principal do programa. Ele interage com o usuário com um menu e um switch-case, e chama as funções de acordo com a escolha do usuário.
As funções então fazem a interação com o banco, e imprimem na tela o resultado.

#### SingerRepository.java
Interface que extende o Repositório JPA, e gera as Querys SQL para consulta, tanto com Derived Queries, como com JPQL.

#### Artista.java e Musica.java
São classes de modelo para representar os artistas e as músicas que o usuário irá escolher, tendo seus próprios atributos.
Também servem como entidades para tabelas no DB que o JPA Hibernate irá criar com as diversas anotações, como: @Entity, @Table, @Id, @GeneratedValue, @Column, @Enumerated, @OneToMany, @ManyToOne.
Atributos da classe Artista: id, nome, tipo, e uma lista de músicas.
Atributos da classe Musica: id, titulo, e artista dono da musica.

#### Tipo.java
Classe tipo Enum, que com a função `fromString` retorna um dos 3 tipos possíveis de artista: SOLO, DUPLA ou BANDA.

### Exemplo de Uso
Ao executar o programa, o usuário pode escolher entre Cadastrar artistas, onde terá de informar o nome e o tipo; Cadastrar músicas, onde terá de informar o título e o artista; Listar músicas; e Buscar músicas por artista, onde terá de informar o nome do artista.


https://github.com/heitor34studio/RenSound/assets/72997122/5c00dee9-c182-4a34-af78-401add7ff801


---

Este é o README atualizado para o projeto RenSound. Ele fornece uma visão geral do projeto, suas funcionalidades, tecnologias utilizadas e como acessar e rodar o projeto. Para mais detalhes, você pode explorar os arquivos do código fonte mencionados.
