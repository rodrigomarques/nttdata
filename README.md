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

