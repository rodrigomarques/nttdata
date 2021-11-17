# Api do Sistema da NTTDATA - Teste

## Configuração
Criar o banco de dados no MYSQL
```
create database NOME_BANCO;
```

Renomear o arquivo src/main/resources/application.properties.init para src/main/resources/application.properties

Alterar as configurações abaixo com os valores corretos:

```
spring.datasource.url=URL_BANCO
spring.datasource.username=USUARIO
spring.datasource.password=SENHA
```

## Rotas do Projeto

### Categoria
- **GET** /categoria

Rota para listar as categorias

**Return** Status Code 200

```
[
    {
        "id": 1,
        "nomeCategoria": "Categoria 1"
    },
    {
        "id": 2,
        "nomeCategoria": "Categoria 2"
    },
    {
        "id": 3,
        "nomeCategoria": "Categoria 3"
    }
]
```

- **POST** /categoria

Rota para salvar uma nova categoria

**Param**

```
{
    "nomeCategoria" : "Nome da Categoria"
}
```

**Return** Status Code 200

```
{
    "id": 3,
    "nomeCategoria": "Categoria 3"
}
```

### Produtos

- **POST** /produto/

Rota para salvar um novo produto

**Param**

```
{
    "nome" : "Camisa",
    "estoque" : 90,
    "precoVenda" : 99.00,
    "categoria" : {
        "id" : 1
    }
}
```

**Return** Status Code 200

```
{
    "id": 7,
    "nome": "Camisa",
    "estoque": 90,
    "precoVenda": 99.00,
    "status": "ATIVO",
    "categoria": {
        "id": 1,
        "nomeCategoria": "Categoria 3"
    }
}
```

- **PUT** /produto/:id

Rota para atualizar um produto

**Param**

```
{
    "nome" : "Camisa Preta",
    "estoque" : 82,
    "precoVenda" : 109.00,
    "categoria" : {
        "id" : 2
    }
}
```

**Return** Status Code 200

```
{
    "id": 2,
    "nome": "Camisa Preta",
    "estoque": 82,
    "precoVenda": 109.00,
    "status": "ATIVO",
    "categoria": {
        "id": 2,
        "nomeCategoria": null
    }
}
```

- **GET** /produto/desativar/:id

Rota para desativar um produto pelo ID

**Return** Status Code 200

```
{
    "id": 2,
    "nome": "Camisa Preta",
    "estoque": 82,
    "precoVenda": 109.0,
    "status": "INATIVO",
    "categoria": {
        "id": 2,
        "nomeCategoria": "Categoria 2"
    }
}
```

- **DELETE** /produto/:id

Rota para excluir um produto pelo ID

**Return** Status Code 200

- **GET** /produto/buscar
- **GET** /produto/buscar?pag=2

Rota para buscar os produtos. O retorno será paginado.

**Return** Status Code 200

```
{
    "content": [
        {
            "id": 1,
            "nome": "Camisa",
            "estoque": 90,
            "precoVenda": 99.0,
            "totalVenda": 8910.0,
            "status": "ATIVO",
            "idCategoria": 1,
            "categoria": "Categoria 3"
        },
        {
            "id": 3,
            "nome": "Camisa",
            "estoque": 90,
            "precoVenda": 99.0,
            "totalVenda": 8910.0,
            "status": "ATIVO",
            "idCategoria": 1,
            "categoria": "Categoria 3"
        },
        {
            "id": 4,
            "nome": "Camisa",
            "estoque": 90,
            "precoVenda": 99.0,
            "totalVenda": 8910.0,
            "status": "ATIVO",
            "idCategoria": 1,
            "categoria": "Categoria 3"
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 3,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalPages": 2,
    "totalElements": 6,
    "size": 3,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 3,
    "empty": false
}
```

- **GET** /produto/buscar/:nome
- **GET** /produto/buscar/:nome?pag=2

Rota para buscar os produtos pelo nome. O retorno será paginado.

**Return** Status Code 200

```
{
    "content": [
        {
            "id": 1,
            "nome": "Camisa",
            "estoque": 90,
            "precoVenda": 99.0,
            "totalVenda": 8910.0,
            "status": "ATIVO",
            "idCategoria": 1,
            "categoria": "Categoria 3"
        },
        {
            "id": 3,
            "nome": "Camisa",
            "estoque": 90,
            "precoVenda": 99.0,
            "totalVenda": 8910.0,
            "status": "ATIVO",
            "idCategoria": 1,
            "categoria": "Categoria 3"
        },
        {
            "id": 4,
            "nome": "Camisa",
            "estoque": 90,
            "precoVenda": 99.0,
            "totalVenda": 8910.0,
            "status": "ATIVO",
            "idCategoria": 1,
            "categoria": "Categoria 3"
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 3,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalPages": 2,
    "totalElements": 6,
    "size": 3,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 3,
    "empty": false
}
```