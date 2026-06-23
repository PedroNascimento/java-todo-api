# 📝 To-Do API REST - Gestão de Tarefas com Autenticação JWT

Este repositório contém uma API REST moderna e de alta performance desenvolvida para a gestão e automação de tarefas cotidianas. O projeto foca em seguir as melhores práticas de engenharia de software, aplicando uma arquitetura em camadas bem definida, segurança *stateless* e isolamento de dados.

---

## 🚀 Status do Projeto: Em Desenvolvimento Avançado

Atualmente, o projeto encontra-se na transição da camada de infraestrutura e segurança para o desenvolvimento das regras de negócio (Services).

### 🛠️ O que já foi implementado:
- **Infraestrutura Local:** Ambiente conteinerizado utilizando **Docker Compose** isolando um banco de dados **PostgreSQL (16.x)**.
- **Evolução de Banco (Database Migrations):** Controle de versionamento do esquema de dados integrado via **Flyway Migrations**.
- **Segurança Core (Spring Security & JWT):** Fluxo de autenticação e proteção de dados 100% *stateless* construído nativamente utilizando tokens assinados via **JJWT** (`io.jsonwebtoken`).
- **Resiliência de Engenharia:** Injeção de dependências nativa via construtores explícitos e declaração manual de getters nas classes críticas de infraestrutura, garantindo um ciclo de compilação robusto e independente de plugins terceiros.
- **Modelagem de Entrada/Saída:** Camada de **DTOs (Data Transfer Objects)** imutáveis estruturada através de **Java Records** e acoplada com **Jakarta Bean Validation**.

---

## 📐 Arquitetura do Sistema

A aplicação segue rigorosamente o padrão de design arquitetural em camadas para garantir baixo acoplamento e alta manutenabilidade:

1. **Controller Layer (REST Endpoints):** Recebe e valida sintaticamente os payloads de entrada. *(Em progresso)*
2. **Service Layer (Business Logic):** Centraliza as regras de negócio e validações da aplicação. *(Próximo Bloco)*
3. **Repository Layer (Spring Data JPA):** Interface abstrata de comunicação otimizada com o banco PostgreSQL.
4. **Security Layer (Spring Security + JWT):** Interceptador global de segurança via filtros nativos (`OncePerRequestFilter`).

---

## 🧰 Tecnologias e Dependências Utilizadas

- **Java 21 (LTS)**
- **Spring Boot 3.3.4**
    - Spring Data JPA
    - Spring Security
    - Spring Validation
    - Spring Boot DevTools
- **PostgreSQL 16.x** (via Docker Compose)
- **Flyway Migrations**
- **JJWT (0.12.6)** (Autenticação Stateless)
- **Springdoc OpenAPI (Swagger UI 2.6.0)** (Documentação interativa de endpoints)
- **Lombok** (Otimização de boilerplate no modelo de domínio)

---

## 🚦 Como Executar o Projeto Localmente

### Pré-requisitos
- **Java 21** instalado.
- **Docker Desktop** ativo na máquina.

### Passo 1: Subir o Banco de Dados
No terminal, na raiz do projeto, execute o comando para iniciar o container do PostgreSQL em segundo plano:
```bash
docker compose up -d