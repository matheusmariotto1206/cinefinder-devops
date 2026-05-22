# 🎬 CineFinder API

API REST para gerenciamento de filmes, avaliações e listas personalizadas.
Desenvolvida com foco em arquitetura moderna e boas práticas de APIs REST.

---

## 🚀 Tecnologias utilizadas

* Java + Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* Banco de dados relacional (Oracle / H2)
* Flyway (migrations)
* OpenAPI / Swagger

---

## 📌 Funcionalidades

### 👤 Autenticação

* Registro de usuário
* Login com retorno de token

### 🎥 Filmes

* Listar filmes (paginado)
* Buscar filme por ID
* Listar reviews de um filme

### ⭐ Reviews

* Criar review
* Listar reviews (paginado)
* Buscar review por ID
* Atualizar review

### 📃 Listas de Filmes

* Criar lista
* Listar listas (paginado)
* Buscar lista por ID
* Atualizar nome da lista
* Deletar lista
* Adicionar filme à lista
* Remover filme da lista

### 🔒 Admin

* Listar todos os usuários

---

## 🔗 Base URL

```
http://localhost:8080
```

---

## 🔐 Autenticação

### ➤ Registro

`POST /auth/register`

```json
{
  "name": "Jon",
  "email": "jon@email.com",
  "password": "123456",
  "age": 20
}
```

---

### ➤ Login

`POST /auth/login`

```json
{
  "email": "jon@email.com",
  "password": "123456"
}
```

📌 Retorna um token JWT

---

## 🎥 Endpoints de Filmes

### ➤ Listar filmes (paginado)

`GET /api/movies?page=0&size=10`

---

### ➤ Buscar filme por ID

`GET /api/movies/{id}`

---

### ➤ Listar reviews de um filme

`GET /api/movies/{id}/reviews`

---

## ⭐ Endpoints de Reviews

### ➤ Criar review

`POST /api/reviews`

```json
{
  "userId": 1,
  "movieId": 1,
  "rating": 8.5,
  "comments": "Muito bom!"
}
```

---

### ➤ Listar reviews (paginado)

`GET /api/reviews?page=0&size=10`

---

### ➤ Buscar review por ID

`GET /api/reviews/{id}`

---

### ➤ Atualizar review

`PUT /api/reviews/{id}`

```json
{
  "rating": 9,
  "comments": "Melhor ainda na segunda vez!"
}
```

---

## 📃 Endpoints de Listas

### ➤ Criar lista

`POST /api/lists`

```json
{
  "name": "Favoritos",
  "userId": 1
}
```

---

### ➤ Listar listas

`GET /api/lists?page=0&size=10`

---

### ➤ Buscar lista por ID

`GET /api/lists/{id}`

---

### ➤ Atualizar lista

`PATCH /api/lists/{id}`

```json
{
  "name": "Top Filmes"
}
```

---

### ➤ Deletar lista

`DELETE /api/lists/{id}`

---

### ➤ Adicionar filme à lista

`POST /api/lists/{id}/movies/{movieId}`

---

### ➤ Remover filme da lista

`DELETE /api/lists/{id}/movies/{movieId}`

---

## 🔒 Admin

### ➤ Listar usuários

`GET /admin`

---

## 📄 Modelos principais

### 🎬 MovieResponse

```json
{
  "id": 1,
  "title": "Inception",
  "description": "Filme sobre sonhos",
  "releaseDate": "2010-07-16",
  "averageRating": 9.0,
  "genres": ["Sci-Fi", "Action"],
  "posterUrl": "url"
}
```

---

### ⭐ ReviewResponse

```json
{
  "id": 1,
  "userName": "Jon",
  "rating": 8.5,
  "comments": "Muito bom!"
}
```

---

### 📃 MovieListResponse

```json
{
  "id": 1,
  "name": "Favoritos",
  "userName": "Jon",
  "movies": []
}
```

---

## 📚 Paginação

Todos os endpoints paginados utilizam:

```
?page=0&size=10&sort=campo,asc
```

---

## 🧪 Documentação Swagger

Acesse:

```
http://localhost:8080/swagger-ui.html
```

ou

```
http://localhost:8080/swagger-ui/index.html
```

---

## ⚙️ Como rodar o projeto

```bash
# Clonar o repositório
git clone <repo-url>

# Entrar na pasta
cd cinefinder

# Rodar aplicação
./mvnw spring-boot:run
```

---
