# CRUD de Clientes - API REST com Spring Boot

Este projeto implementa um CRUD completo de clientes utilizando **Spring Boot**, com acesso ao banco de dados **H2**. Ele segue as operações básicas de uma API REST:

- **Busca paginada de recursos**
- **Busca de recurso por ID**
- **Inserir novo recurso**
- **Atualizar recurso**
- **Deletar recurso**

A API trata as seguintes exceções:

- **404**: Id não encontrado (para GET por id, PUT e DELETE).
- **422**: Erro de validação (mensagens customizadas para dados inválidos).

## Requisitos

- Java 11 ou superior
- Maven
- IDE como IntelliJ ou Eclipse
- Banco de dados H2 para testes
- Postman para testar as requisições

## Funcionalidades

### 1. Busca por ID
- **GET /clients/{id}**: Retorna o cliente com o ID especificado. Retorna 404 caso não exista.

### 2. Busca Paginada de Clientes
- **GET /clients?page={page}&size={size}&sort={sort}**: Retorna uma lista paginada de clientes. O parâmetro `sort` pode ser usado para ordenar os resultados.

### 3. Inserir Novo Cliente
- **POST /clients**: Insere um novo cliente com os dados passados no corpo da requisição.

### 4. Atualizar Cliente
- **PUT /clients/{id}**: Atualiza o cliente com o ID especificado. Retorna 404 se o cliente não existir.

### 5. Deletar Cliente
- **DELETE /clients/{id}**: Deleta o cliente com o ID especificado. Retorna 404 se o cliente não existir.

## Exceções e Validações

- **Nome**: Não pode ser vazio.
- **Data de Nascimento**: Não pode ser uma data futura (usando `@PastOrPresent`).

### Exemplos de Requisição

#### Inserir Cliente
```json
POST /clients
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
