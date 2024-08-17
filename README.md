# bank-api
# Projeto LocalStack com Docker Compose

Este projeto configura o LocalStack com Docker Compose para emular os serviços da AWS localmente, como o DynamoDB. Siga o passo a passo abaixo para configurar e iniciar o LocalStack.

## Pré-Requisitos

Antes de começar, certifique-se de que você possui os seguintes pré-requisitos instalados:

- **[Docker](https://docs.docker.com/get-docker/)**: Plataforma para criar e gerenciar containers.
- **[Docker Compose](https://docs.docker.com/compose/install/)**: Ferramenta para definir e executar aplicações Docker multi-container.
- **[AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html)**: Interface de linha de comando para interagir com os serviços da AWS.
- **[Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)** (opcional): Para clonar o repositório.

## Passo a Passo para Subir o LocalStack

### 1. Clone o Repositório

Se você ainda não tem o repositório clonado, faça isso com o comando:

```bash
git clone <bank-api>
cd <bank-api>
```
### 2. Garanta que o script tenha permissões de execução:
```bash
chmod +x create_dynamodb_table.sh
```
### 3.  Suba o LocalStack e Crie a Tabela
```bash
docker-compose up --build
```


Este README é um guia completo que explica como configurar e executar o LocalStack usando Docker Compose em seu projeto, permitindo a emulação local de serviços AWS como DynamoDB. Ele está pronto para ser usado em seu projeto.

__________________________________________________________________________
# LocalStack Project with Docker Compose

This project sets up LocalStack with Docker Compose to emulate AWS services locally, such as DynamoDB. Follow the step-by-step guide below to configure and start LocalStack.

## Prerequisites

Before you begin, make sure you have the following prerequisites installed:

- **[Docker](https://docs.docker.com/get-docker/)**: Platform for creating and managing containers.
- **[Docker Compose](https://docs.docker.com/compose/install/)**: Tool to define and run multi-container Docker applications.
- **[AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html)**: Command line interface to interact with AWS services.
- **[Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)** (optional): To clone the repository.

## Steps to Set Up LocalStack

### 1. Clone the Repository

If you have not yet cloned the repository, do so with the command:

```bash
git clone <bank-api>
cd <bank-api>
```
### 2. Ensure the script has execution permissions:
```bash
chmod +x create_dynamodb_table.sh
```
### 3.  Launch LocalStack and Create the Table
```bash
docker-compose up --build
```


This English version of the README maintains the structure and instructions of the original Portuguese version, tailored for an English-speaking audience.
