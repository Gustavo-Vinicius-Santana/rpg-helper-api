# 📌 RPG Helper API

## 📖 Sobre
**RPG Helper API** é uma aplicação **REST** desenvolvida em **Java com Spring Boot**, que utiliza **PostgreSQL** como banco de dados.  
Ela foi projetada para auxiliar no gerenciamento de recursos de RPG de mesa.

---

## 🛠 Tecnologias

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Docker Compose](https://img.shields.io/badge/Docker_Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://docs.docker.com/compose/)

---

## ⚙️ Pré-requisitos
Antes de rodar o projeto, você precisa ter instalado em sua máquina:
- [Java 21+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/) + [Docker Compose](https://docs.docker.com/compose/)

---

## ▶️ Como rodar a aplicação

### 1. Rodando com **Docker Compose**
O jeito mais simples: subir API e banco juntos em containers.

```bash
# Clonar o repositório
git clone https://github.com/Gustavo-Vinicius-Santana/rpg-helper-api
cd rpg-helper-api

# Subir os containers
docker compose up -d --build
```
➡️ A API ficará disponível em:
```arduino
http://localhost:8080
```

---

### 2. Rodando localmente pelo terminal
Caso prefira rodar a API fora do Docker, você pode usar Maven e apontar para um PostgreSQL do docker
```bash
# Clonar o repositório
git clone https://github.com/Gustavo-Vinicius-Santana/rpg-helper-api
cd rpg-helper-api

# rodar banco de dados docker
docker compose up -d postgres

# Rodar a aplicação
./mvnw spring-boot:run
```
➡️ A API ficará disponível em:
```arduino
http://localhost:8080
```

---
### 3. Rodando pelo IntelliJ IDEA
Você também pode rodar a aplicação diretamente pelo **IntelliJ IDEA**, utilizando o suporte a variáveis de ambiente.

```bash
# Clonar o repositório
git clone https://github.com/Gustavo-Vinicius-Santana/rpg-helper-api
cd rpg-helper-api

# Rodar apenas o banco de dados no Docker
docker compose up -d postgres
````
➡️ Depois configure o IntelliJ:

1. Abra o projeto no **IntelliJ IDEA**.
2. Vá em **Run > Edit Configurations...**
3. Selecione a configuração da sua aplicação (`rpg-helper-api`).
4. Em **Environment variables**, clique em `...` e carregue o arquivo `.env` do projeto.
5. No IntelliJ você pode usar o formato `KEY=VALUE` (o mesmo do `.env`).
6. Salve e rode a aplicação pelo **IntelliJ IDEA** (**Shift + F10**).  