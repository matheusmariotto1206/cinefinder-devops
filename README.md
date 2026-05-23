# CineFinder API — Entrega DevOps

API REST para filmes, reviews e listas. CI/CD no Azure DevOps, deploy em VM Azure e banco Oracle (nuvem FIAP).

---

## Descrição da solução

Usuários se registram, autenticam com JWT e executam CRUD em reviews e listas. Reviews relacionam usuário e filme; listas agrupam filmes por usuário. Migrations Flyway no Oracle; deploy via Docker na VM após build e testes na pipeline.

---

## Benefícios de negócio

- **CI/CD:** padroniza releases e reduz deploy manual.
- **Testes automatizados:** validação antes de publicar na VM.
- **Nuvem:** API e banco acessíveis para demonstração e persistência real dos dados.

---

## Arquitetura

Diagrama e texto dissertativo: [docs/arquitetura-macro.md](docs/arquitetura-macro.md)  
Fonte Mermaid: [docs/diagrama/arquitetura.mmd](docs/diagrama/arquitetura.mmd)

Fluxo resumido: GitHub → Azure DevOps (CI, aprovação, CD) → Docker → VM Azure → Oracle FIAP.

---

## Ferramentas e versões

| Ferramenta | Versão |
|------------|--------|
| Java (Temurin) | 17 |
| Spring Boot | 4.0.3 |
| Gradle | wrapper do projeto |
| Flyway | starter Spring Boot |
| Oracle JDBC | ojdbc11 |
| H2 | profile `dev` (testes locais e CI) |
| Springdoc OpenAPI | 3.0.2 |
| Docker | 24+ na VM |
| Azure DevOps | Pipelines |
| Postman | collection em `postman/` |

---

## Pré-requisitos

- JDK 17
- Git
- Docker (opcional, para testar container)

---

## Clone e execução local

```powershell
git clone https://github.com/matheusmariotto1206/cinefinder-devops.git
cd cinefinder-devops
.\gradlew.bat test
```

### Oracle (desenvolvimento)

```powershell
$env:SPRING_DATASOURCE_URL="jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"
$env:SPRING_DATASOURCE_USERNAME="SEU_RM"
$env:SPRING_DATASOURCE_PASSWORD="SUA_SENHA"
.\gradlew.bat bootRun
```

Swagger local: http://localhost:8080/swagger-ui/index.html

### H2 (apenas profile dev)

```powershell
$env:SPRING_PROFILES_ACTIVE="dev"
.\gradlew.bat bootRun
```

Não usar H2 em produção na VM.

---

## Deploy na VM (produção)

API em **vm-cinefinder-api** — IP **172.171.193.127**, porta **8080**.

```bash
git clone https://github.com/matheusmariotto1206/cinefinder-devops.git
cd cinefinder-devops
docker build -f Dockerfile.runtime -t cinefinder .
docker run -d -p 8080:8080 \
  -e SPRING_DATASOURCE_URL="jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL" \
  -e SPRING_DATASOURCE_USERNAME="SEU_RM" \
  -e SPRING_DATASOURCE_PASSWORD="SUA_SENHA" \
  --name cinefinder cinefinder
```

Swagger: http://172.171.193.127:8080/swagger-ui/index.html

---

## Pipeline Azure DevOps

Arquivo `azure-pipelines.yml`:

1. **CI** — `./gradlew test build` (profile dev/H2 no agente) e artefato JAR  
2. **Aprovação manual** — gate antes do deploy  
3. **CD** — cópia do JAR por SSH, `docker build` com `Dockerfile.runtime` e `docker run` na VM  

### Executar

1. Projeto no Azure DevOps → **Pipelines** → Run na branch `main`  
2. Aprovar o stage manual  
3. Validar API na URL da VM  

Variáveis secretas: `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`.  
Service connection SSH: `vm-cinefinder-ssh`. Environment: `production` com aprovadores.

---

## DDL

- `docs/schema.ddl`  
- Migrations: `src/main/resources/db/migration/oracle/`

Tabelas: `cf_user`, `cf_movie`, `cf_review`, `cf_movie_list` (relacionamentos por FK).

---

## Postman (CRUD)

Collection: `postman/CineFinder.postman_collection.json`

Use a pasta **VIDEO - CRUD completo** (requests 1 a 7) ou Auth + Reviews CRUD.

`baseUrl` na VM: `http://172.171.193.127:8080`

---

## Autenticação

`POST /auth/register` — `POST /auth/login` (retorna JWT)  
Header: `Authorization: Bearer {token}`

---

## Endpoints principais

**Filmes:** `GET /api/movies`, `GET /api/movies/{id}`

**Reviews (CRUD):** `POST|GET|PUT|DELETE /api/reviews`, `GET /api/reviews/{id}`

**Listas (CRUD):** `POST|GET|PATCH|DELETE /api/lists`

**Admin:** `GET /admin`

Paginação: `?page=0&size=10&sort=campo,asc`

---

## Swagger

- Local: http://localhost:8080/swagger-ui/index.html  
- VM: http://172.171.193.127:8080/swagger-ui/index.html
