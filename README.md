# Autenticação e Autorização com Spring Security e JWT

Este projeto implementa um sistema de autenticação e autorização utilizando Spring Boot, Spring Security, JWT (JSON Web Token) e controle de permissões baseado em roles.

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Banco de Dados (H2)
- JPA/Hibernate
- Lombok
- Maven

## Funcionalidades

- Registro de usuários
- Autenticação com JWT
- Autorização baseada em roles
- Proteção de rotas com Spring Security
- Refresh Token (opcional)

## Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/anibaljuniorpg/autorizacai-autenticacao.git
   
2. Instale as dependências utilizando Maven:

   ```bash
   mvn install

## Endpoints Principais

- POST api/auth/login - Login na aplicação.
- POST api/auth/register - Registrar um novo usuário na aplicação.

### Autenticação

- `POST api/auth/register` - Registra um novo usuário
- `POST api/auth/login` - Autentica o usuário e retorna um JWT


## Autores

- [Anibal Júnior](https://github.com/anibaljuniorpg)
