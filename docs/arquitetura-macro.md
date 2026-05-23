# Arquitetura macro — CineFinder DevOps

## Diagrama

Arquivo fonte: `docs/diagrama/arquitetura.mmd`

```mermaid
flowchart TB
    DEV["Acesso - Desenvolvedor / Professor"]

    subgraph ADO["Azure DevOps"]
        GH["GitHub - cinefinder-devops"]
        CI["CI - Gradle test + build"]
        APR["Aprovacao manual"]
        CD["CD RELEASE"]
        GH --> CI --> APR --> CD
    end

    subgraph BUILD["Criacao da Imagem pelo Docker"]
        DFILE["DOCKERFILE"]
        IMG["Imagem Docker cinefinder"]
        DFILE --> IMG
    end

    subgraph AZURE["Microsoft Azure"]
        ACR["ACR - Container Registry"]
        VM["VM Linux - API porta 8080"]
        DB[("Oracle FIAP")]
        ACR <--> VM
    end

    DEV --> GH
    CI -->|BUILD| DFILE
    IMG -->|PUSH| ACR
    CD --> VM
    VM -->|JDBC| DB
    DEV -->|Postman e Swagger| VM
```

## Componentes

| Componente | Função |
|------------|--------|
| GitHub | Código, pipeline YAML, Postman, DDL |
| CI | Testes e build do JAR |
| Aprovação manual | Revisão antes do deploy |
| CD | Deploy Docker na VM |
| VM Azure | API em produção (172.171.193.127:8080) |
| Oracle FIAP | Persistência relacional |
| Postman / Swagger | Testes e documentação da API |

## Fluxo da pipeline

1. Push no repositório dispara a pipeline.
2. CI executa testes (H2) e gera o JAR.
3. Aprovação manual libera o CD.
4. CD envia o JAR à VM, monta a imagem e sobe o container.
5. A API conecta ao Oracle; CRUD persiste dados no banco.
