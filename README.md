<h1 align="center" id="title">Rick and Morty</h1>
<h3 align="center">
   Aplicação onde é possivel conhecer mais sobre os personagens do Rick and Morty 
</h3>

<br/>

<p align="center" id="icons">
  <a href="#icons">
    <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/joao01sb/Rick_and_Morty-Personagens?color=2304D361">
  </a>
  <a href="https://github.com/guilhermePalma/RecyclerView">
    <img alt="Repository size" src="https://img.shields.io/github/repo-size/joao01sb/Rick_and_Morty-Personagens">
  </a>
  <a href="https://github.com/guilhermePalma/RecyclerView/commits/main">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/joao01sb/Rick_and_Morty-Personagens">
  </a>
</p>

Tabela de conteúdos
=================
<!--ts-->
 * [Sobre o projeto](#-sobre-o-projeto)
   * [Funcionalidades](#-funcionalidades)
   * [Como executar o projeto](#-como-executar-o-projeto)
     * [Pré-requisitos](#pré-requisitos)
     * [Baixando o Projeto](#-baixando-o-projeto)
   * [Tecnologias](#-tecnologias)
<!--te-->

# 💻 Sobre o projeto

**Rick and Morty Personagens** - Projeto desenvolvido para o Estudo das bibliotecas do android jetpack, Gerenciamento de navegação entre
fragments, paginação de dados recebidos pela API Rest do Rick And Morty, também com uso do Koin para injeção de dependencias e Room para manipular dados no Banco SQlite, e também toda parte de cominição web e do banco de dados e usada via injeção de dependência visando utilizar somente quando nescessário.

## 📰 Funcionalidades

- [x] A Aplicação ira exibir:
  - [x] Lista de personagens da Animação Rick and Morty onde e possivel scrollar sobre varios personagens recebidos da api
  - [x] Imagem do Personagem
  - [x] Nome do Personagem

- [x] Outros Recuros:
  - [X] Manipulação de Dados entre Activities
  - [X] Banco de Dados Interno com Room
  - [X] Fragment
  - [X] Paging
  - [X] injeção de dependencia
  - [X] viewModels
  - [X] Corotinas
  

## 🚀 Como executar o projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
- [Git](https://git-scm.com) → Atualizações e Versionamento no Codigo 
- [Android Studio](https://developer.android.com/studio/) → Editor da Google voltado ao Desenvolvimento Android ou Intellij Idea

<br/>

Este Projeto é divido em 8 Principais Partes:
1. [Configurações das Telas](app/src/main/java/com/app/rickandmorty/ui)
2. [Layout das Telas](app/src/main/res/layout)
3. [navegação das Telas](app/src/main/res/navegation)
4. [Classes modelo](app/src/main/java/com/app/rickandmorty/models)
5. [injeção de dependecia](app/src/main/java/com/app/rickandmorty/di)
6. [banco de dados e Dao](app/src/main/java/com/app/rickandmorty/data)
7. [dominio e repositorios](app/src/main/java/com/app/rickandmorty/domain)
8. [endpoints da api](app/src/main/java/com/app/rickandmorty/connection)

### 📥 Baixando o Projeto

```bash

# Clone este repositório
$ git clone https://github.com/joao01sb/Rick_and_Morty-Personagens.git

# Acesse a pasta do projeto no terminal/cmd
$ cd Rick_and_Morty-Personagens

```


## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:
-   **[Kotlin/Android](https://developer.android.com/kotlin?gclid=CjwKCAiA5Y6eBhAbEiwA_2ZWIaJsIyqOWs0svWNLip49qw0yd8KdsdO-l78Fntr-p09L8H_L0dtvyxoCyJoQAvD_BwE&gclsrc=aw.ds)**

## 💪 Como contribuir no projeto

1. Faça um **fork** do projeto.
2. Crie uma nova branch com as suas alterações: `git checkout -b my-feature`
3. Salve as alterações e crie uma mensagem de commit contando o que você fez: `git commit -m "feature: My new feature"`
4. Envie as suas alterações: `git push origin my-feature`





