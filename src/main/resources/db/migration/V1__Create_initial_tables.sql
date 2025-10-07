-- Cria a tabela de usuários
CREATE TABLE tb_user (
    id_user BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    idade INT,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255),
    role VARCHAR(50) NOT NULL DEFAULT 'USER'
);

-- Cria a tabela de cursos
CREATE TABLE tb_curso (
    id_curso BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    status VARCHAR(255) NOT NULL CHECK (status IN ('ATIVO', 'INATIVO', 'EM_BREVE')),
    descricao TEXT
);

-- Cria a tabela de posts, com chaves estrangeiras para usuário e curso
CREATE TABLE tb_posts (
    id_post BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255),
    descricao TEXT,
    data_publicacao TIMESTAMP WITHOUT TIME ZONE,
    user_id BIGINT,
    curso_id BIGINT,
    CONSTRAINT fk_posts_user FOREIGN KEY(user_id) REFERENCES tb_user(id_user),
    CONSTRAINT fk_posts_curso FOREIGN KEY(curso_id) REFERENCES tb_curso(id_curso)
);

-- Cria a tabela de comentários, com chave estrangeira para post
CREATE TABLE tb_comments (
    id_comment BIGSERIAL PRIMARY KEY,
    descricao TEXT,
    post_id BIGINT,
    CONSTRAINT fk_comments_post FOREIGN KEY(post_id) REFERENCES tb_posts(id_post)
);

-- Cria a tabela de junção para o relacionamento N-para-N entre usuários e cursos
CREATE TABLE user_curso (
    user_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, curso_id),
    CONSTRAINT fk_user_curso_user FOREIGN KEY(user_id) REFERENCES tb_user(id_user),
    CONSTRAINT fk_user_curso_curso FOREIGN KEY(curso_id) REFERENCES tb_curso(id_curso)
);