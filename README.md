# Cursos API

Este projeto é um backend desenvolvido em Java utilizando Spring Boot, destinado ao gerenciamento de cursos, usuários e posts relacionados. Ele utiliza PostgreSQL como banco de dados e segue boas práticas de desenvolvimento, incluindo autenticação JWT e migrações com Flyway.

## Principais Funcionalidades
- Cadastro, consulta, atualização e exclusão de cursos
- Gerenciamento de usuários
- Autenticação e autorização via JWT
- Posts relacionados aos cursos

## Como Executar
1. Certifique-se de ter o Java 17+ e o Maven instalados.
2. Configure o banco de dados PostgreSQL e as variáveis de ambiente necessárias (pode usar um arquivo `.env`).
3. Execute as migrações com Flyway (automático ao iniciar).
4. Inicie a aplicação:
   ```bash
   mvn spring-boot:run
   ```

## Principais Endpoints

### Autenticação
- `POST /auth/login` — Realiza login e retorna o token JWT
- `POST /auth/register` — Cadastro de novo usuário

### Cursos
- `GET /curso/all` — Lista todos os cursos
- `GET /curso/all/{id}` — Consulta um curso específico
- `POST /curso/create` — Cria um novo curso
- `PUT /curso/alter/{id}` — Atualiza um curso
- `DELETE /curso/delete/{id}` — Remove um curso

### Usuários
- `GET /users/all` — Lista todos os usuários
- `GET /users/all/{id}` — Consulta um usuário específico
- `POST /users/create` — Cria um novo usuário
- `PATCH /users/alter/{id}` — Atualiza um usuário
- `DELETE /users/delete/{id}` — Remove um usuário

### Posts
- `GET /Post/all` — Lista todos os posts
- `GET /Post/all/{id}` — Consulta um post específico
- `POST /Post/create` — Cria um novo post
- `DELETE /Post/delete/{id}` — Remove um post

### Comment
- `GET /comment/all` — Lista todos os comentários
- `GET /comment/all/{id}` — Consulta um comentário específico
- `POST /comment/create` — Cria um novo comentário
- `DELETE /comment/delete/{id}` — Remove um comentário

### Modulo
- `GET /modulo/all` — Lista todos os módulos
- `GET /modulo/all/{id}` — Consulta um módulo específico
- `POST /modulo/create` — Cria um novo módulo
- `DELETE /modulo/delete/{id}` — Remove um módulo

### Aulas
- `GET /aulas/all` — Lista todas as aulas
- `GET /aulas/{id}` — Consulta uma aula específica
- `POST /aulas/create` — Cria uma nova aula
- `DELETE /aulas/delete/{id}` — Remove uma aula

## Modelo do Banco de Dados

### Tabela: Curso
| Campo        | Tipo         | Descrição         |
|--------------|--------------|-------------------|
| id_curso     | BIGSERIAL PK | Identificador     |
| nome         | VARCHAR      | Nome do curso     |
| descricao    | TEXT         | Descrição         |
| status       | VARCHAR      | Estado do curso   |

### Tabela: User
| Campo        | Tipo         | Descrição         |
|--------------|--------------|-------------------|
| id_user      | BIGSERIAL PK | Identificador     |
| nome         | VARCHAR      | Nome do usuário   |
| email        | VARCHAR      | Email             |
| senha        | VARCHAR      | Senha (hash)      |

### Tabela: Post
| Campo        | Tipo         | Descrição         |
|--------------|--------------|-------------------|
| id_post      | BIGSERIAL PK | Identificador     |
| titulo       | VARCHAR      | Título do post    |
| conteudo     | TEXT         | Conteúdo          |
| curso_id     | BIGINT FK    | Curso relacionado |
| user_id      | BIGINT FK    | Autor do post     |

### Tabela: Comment
| Campo        | Tipo         | Descrição         |
|--------------|--------------|-------------------|
| id_comment   | BIGSERIAL PK | Identificador     |
| descricao    | TEXT         | Descrição         |
| post_id      | BIGINT FK    | Post relacionado  |

### Tabela: Modulo
| Campo        | Tipo         | Descrição         |
|--------------|--------------|-------------------|
| id_modulo    | BIGSERIAL PK | Identificador     |
| titulo       | VARCHAR      | Título do módulo  |
| descricao    | TEXT         | Descrição         |
| ordem        | INTEGER      | Ordem do módulo   |
| curso_id     | BIGINT FK    | Curso relacionado |

### Tabela: Aulas
| Campo        | Tipo         | Descrição         |
|--------------|--------------|-------------------|
| id_aula      | BIGSERIAL PK | Identificador     |
| titulo       | VARCHAR      | Título da aula    |
| descricao    | TEXT         | Descrição         |
| recursos     | VARCHAR      | Recursos          |
| ordem        | INTEGER      | Ordem da aula     |
| id_modulo    | BIGINT FK    | Módulo relacionado |

## Dependências Principais
- Spring Boot
- Spring Data JPA
- PostgreSQL Driver
- Flyway
- JWT (io.jsonwebtoken)
- Lombok
- java-dotenv

## Contribuição
Pull requests são bem-vindos! Para grandes mudanças, abra uma issue primeiro para discutir o que você gostaria de modificar.

## Licença

Este projeto está sob licença MIT.

