# Task API — Gerenciador de Tarefas

API REST desenvolvida com **Java 21 e Spring Boot 4** para gerenciamento de tarefas.

O projeto implementa operações CRUD, persistência de dados com JPA/Hibernate, validação de informações e autenticação baseada em JWT, com endpoints protegidos pelo Spring Security.

Desenvolvido como projeto prático de estudo e portfólio, com foco na aplicação de conceitos de desenvolvimento backend.

## Tecnologias utilizadas

- **Java 21** — linguagem de programação.
- **Spring Boot 4** — framework para desenvolvimento da aplicação.
- **Spring Web** — construção dos endpoints REST.
- **Spring Data JPA** — acesso e persistência de dados.
- **Hibernate** — implementação do ORM.
- **H2 Database** — banco de dados em memória.
- **Spring Security** — autenticação e proteção dos endpoints.
- **JWT** — autenticação baseada em tokens.
- **Bean Validation** — validação dos dados recebidos.
- **Maven** — gerenciamento de dependências e build.
- **JUnit e MockMvc** — testes automatizados.

## Funcionalidades

- Criar tarefas.
- Listar todas as tarefas.
- Buscar uma tarefa pelo ID.
- Atualizar tarefas existentes.
- Excluir tarefas.
- Validar campos obrigatórios.
- Tratar erros e retornar respostas HTTP apropriadas.
- Autenticar usuários por meio de JWT.
- Proteger os endpoints de gerenciamento de tarefas.

## Endpoints

### Autenticação

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/auth/login` | Autenticar usuário e obter token JWT |

### Gerenciamento de tarefas

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/tarefas` | Criar uma tarefa |
| GET | `/tarefas` | Listar todas as tarefas |
| GET | `/tarefas/{id}` | Buscar tarefa pelo ID |
| PUT | `/tarefas/{id}` | Atualizar uma tarefa |
| DELETE | `/tarefas/{id}` | Excluir uma tarefa |

**Importante:** todos os endpoints de `/tarefas` exigem autenticação. O endpoint `/auth/login` é utilizado para obter o token.

## Autenticação JWT

Para acessar os endpoints protegidos, primeiro é necessário realizar a autenticação.

**1. Enviar uma requisição para:**

`POST /auth/login`

Corpo da requisição:

```json
{
  "username": "SEU_USUARIO",
  "password": "SUA_SENHA"
}
```

**2. Utilizar o token retornado**

Nas próximas requisições, envie o token no cabeçalho HTTP:

```http
Authorization: Bearer SEU_TOKEN
```

Sem um token válido, a API retorna HTTP 401 (Unauthorized).

## Exemplo de criação de tarefa

**Requisição:** `POST /tarefas`

```json
{
  "titulo": "Estudar Spring Boot",
  "descricao": "Praticar desenvolvimento de APIs REST",
  "concluida": false
}
```

## Validação e tratamento de erros

A API implementa validação dos dados recebidos e tratamento de erros.

| Código HTTP | Descrição |
|---|---|
| 400 | Dados inválidos ou erro de validação |
| 401 | Autenticação ausente ou inválida |
| 404 | Recurso não encontrado |

## Banco de dados

O projeto utiliza o **H2 Database em memória**, integrado ao Spring Data JPA e Hibernate.

Os dados são armazenados temporariamente e são perdidos quando a aplicação é encerrada ou reiniciada.

## Pré-requisitos

- Java 21 ou superior.
- Git.
- Maven Wrapper incluído no projeto.

Não é necessário instalar o Maven separadamente, pois o projeto já possui o Maven Wrapper.

## Configuração e execução

**1. Clonar o repositório**

```bash
git clone https://github.com/fredjoaquim/task-api.git
```

**2. Entrar na pasta do projeto**

```bash
cd task-api
```

**3. Configurar a variável de ambiente JWT_SECRET**

No Linux:

```bash
export JWT_SECRET="sua-chave-secreta-com-pelo-menos-32-bytes"
```

Utilize uma chave forte e mantenha-a fora do repositório.

**4. Executar a aplicação**

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível, por padrão, em:

`http://localhost:8080`

## Testes automatizados

O projeto utiliza JUnit e MockMvc para executar testes automatizados.

Para executar os testes:

```bash
./mvnw test
```

Os testes implementados verificam:

- Inicialização do contexto da aplicação.
- Autenticação e criação de uma tarefa por meio de uma requisição HTTP simulada, incluindo a validação da resposta.

A execução dos testes também exige que a variável de ambiente `JWT_SECRET` esteja configurada.

## Estrutura do projeto

A aplicação utiliza a separação de responsabilidades entre as principais camadas:

- **Controller:** recebe e processa as requisições HTTP.
- **Service:** concentra a lógica de negócio.
- **Repository:** realiza o acesso aos dados.
- **Entity:** representa a entidade persistida no banco de dados.
- **Security:** configura a autenticação e a proteção dos endpoints.

## Objetivo do projeto

Este projeto foi desenvolvido para consolidar conhecimentos em desenvolvimento backend com Java e Spring Boot, aplicando conceitos de APIs REST, arquitetura em camadas, persistência de dados, validação, autenticação JWT e testes automatizados.