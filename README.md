# Teste Prático Prothera
Solução desenvolvida para o desafio técnico da vaga de Desenvolvedor Full Stack Júnior.

## Tecnologias Utilizadas
- Java
- Maven
- JDK 25
- Git
- Github

## Sobre o Projeto
O projeto consiste em uma aplicação Java para gerenciamento de uma lista de funcionários.
Foram implementados os seguintes requisitos:
- Cadastro dos funcionários.
- Remoção do funcionário João.
- Exibição dos dados dos funcionários.
- Formatação das datas e salários.
- Aumento salarial de 10%.
- Agrupamento de funcionários por função.
- Identificação dos funcionários que fazem aniversário em Outubro e Dezembro.
- Identificação do funcionário mais velho.
- Ordenação de funcionários por ordem alfabética.
- Cálculo total dos salários dos funcionários.
- Cálculo de quantidade de salários mínimos recebidos por funcionário.

## Estrutura do Projeto

### Pessoa
Classe responsável por representar uma pessoa, contendo:
- Nome
- Data de Nascimento

### Funcionário
Classe que herda de `Pessoa` e adiciona:
- Salário
- Função

### Main
Classe responsável pela execução da aplicação e implementação dos requisitos do desafio.

## Conceitos utilizados
- Programação Orientada a Objetos
- Herança
- Encapsulamento
- Collections
- `ArrayList`
- `HashMap`
- `LocalDate`
- `BigDecimal`
- Lambda Expressions
- Ordenação de listas
- Formatação de datas e valores monetários

## Como executar

### Pré-requisitos
- JDK 25
- Maven

### Execução
O projeto pode ser executado através de uma IDE compatível com projetos Maven, como NetBeans, IntelliJ IDEA ou Visual Studio Code.