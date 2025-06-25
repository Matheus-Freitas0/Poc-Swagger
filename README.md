# 📘 Swagger POC - Spring Boot

Este é um projeto de Prova de Conceito (POC) utilizando **Spring Boot** com **OpenAPI 3 (Swagger)** para documentação de uma API RESTful simples de gerenciamento de usuários.

## ✨ Funcionalidades

- 📄 Documentação interativa da API com Swagger UI
- 🔍 Buscar usuário por ID
- 📋 Listar todos os usuários
- ➕ Criar um novo usuário
- ✏️ Atualizar um usuário existente
- ❌ Deletar um usuário

## 🧰 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5.3
- Spring Data JPA
- PostgreSQL
- Lombok
- Springdoc OpenAPI 3 (`springdoc-openapi-starter-webmvc-ui`)

## 📁 Estrutura do Projeto

```
com.poc.swagger
├── controller      # Endpoints da API
├── domain          # Entidade User
├── repository      # Interface JpaRepository
└── service         # Regras de negócio
```

## 📑 Documentação da API

Ao iniciar o projeto, acesse a documentação Swagger em:

```
http://localhost:8080/swagger-ui.html
```

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/swagger-poc.git
   cd swagger-poc
   ```

2. Configure seu banco PostgreSQL e ajuste as credenciais no `application.properties`.

3. Execute o projeto com Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

## 🧪 Endpoints Disponíveis

| Método | Endpoint               | Descrição                     |
|--------|------------------------|-------------------------------|
| GET    | `/api/swagger/users`   | Listar todos os usuários      |
| GET    | `/api/swagger/user/{id}` | Buscar usuário por ID         |
| POST   | `/api/swagger/user`    | Criar novo usuário            |
| PUT    | `/api/swagger/user/update/{id}` | Atualizar dados do usuário     |
| DELETE | `/api/swagger/user/{id}` | Deletar usuário               |

## 🧑‍💻 Autor

Desenvolvido por **Matheus M. Freitas**.  
[LinkedIn](https://www.linkedin.com/in/matheusfreitasdev) • [GitHub](https://github.com/Matheus-Freitas0)
