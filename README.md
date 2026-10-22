# Task API — Gerenciador de Tarefas

API REST desenvolvida com Java e Spring Boot para gerenciamento de tarefas, com operações CRUD, persistência em banco de dados, validação de dados e autenticação com JWT.

## Tecnologias utilizadas

- Java 25
- Spring Boot 4
- Spring Web
- Spring Data JPA
- Hibernate
- Banco de dados H2
- Spring Security
- JWT
- Maven
- Bean Validation

## Funcionalidades

- Criar tarefas
- Listar todas as tarefas
- Buscar tarefa por ID
- Atualizar tarefas
- Excluir tarefas
- Validar campos obrigatórios
- Retornar erros HTTP apropriados
- Proteger os endpoints com autenticação JWT

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/auth/login` | Realizar login e obter autenticação |
| POST | `/tarefas` | Criar uma tarefa |
| GET | `/tarefas` | Listar tarefas |
| GET | `/tarefas/{id}` | Buscar tarefa por ID |
| PUT | `/tarefas/{id}` | Atualizar tarefa |
| DELETE | `/tarefas/{id}` | Excluir tarefa |

Os endpoints de tarefas exigem autenticação. Envie o token JWT no cabeçalho `Authorization`, usando o formato `Bearer SEU_TOKEN`.

## Exemplo de criação de tarefa

Requisição: `POST /tarefas`

```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Praticar desenvolvimento de APIs REST",
  "concluida": false
}
```

## Tratamento de erros

A API possui validação de dados e tratamento de erros, incluindo:

- HTTP 400: dados inválidos
- HTTP 401: autenticação ausente ou inválida
- HTTP 404: tarefa não encontrada

## Banco de dados

O projeto utiliza o H2 em memória com JPA/Hibernate. Os dados são armazenados temporariamente e são perdidos quando a aplicação é reiniciada.

## Configuração

É necessário ter o Java e o Maven disponíveis para executar o projeto.

A aplicação utiliza a variável de ambiente `JWT_SECRET` para configurar a chave de assinatura dos tokens. Defina uma chave segura com pelo menos 32 bytes antes de iniciar a aplicação.

Não publique a chave secreta nem outras credenciais no repositório.

## Como executar

1. Clone o repositório.
2. Configure a variável de ambiente `JWT_SECRET`.
3. Abra o projeto no IntelliJ IDEA ou execute-o com Maven.
4. Inicie a classe principal `TaskApiApplication`.

Por padrão, a aplicação utiliza a porta `8080`.

## Objetivo do projeto

Projeto de estudo e portfólio para praticar desenvolvimento backend com Java, Spring Boot, persistência de dados, APIs REST, validação e segurança com JWT.
