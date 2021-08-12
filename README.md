# Autenticação de rotas - Api Gateway Kong - Spring Boot - Docker

## Sobre
Esta poc visa a integração de serviços via api gateway Kong, o objetivo é criar validações em rotas, para que apenas consumidores devidamente cadastrados e autenticados consiga consumir determinado serviço. A partir de um serviço java, com intuito administrativo, é possível criar autenticaçao a uma rota com um plugin, criar consumidores, criar chave de autenticação a consumidores, deletar uma chave de autenticação, consultar todas chaves existentes e consultar chaves de um consumidor específico. 

## Requisitos
  - docker
  - docker-compose

## Instalação
Criar uma network para os containers dockers
```
docker network create kong-net
```
Verificar network criada
```
docker network ls
```
Na pasta docker-kong subir serviços (Kong, Migrations Kong, Konga, Postgres)
```
docker-compose up -d
```
Verificar containers online (imagens que devem estar online: kong:2.5.0-alpine, pantsel/konga:latest, postgres:9.5, as migrations não devem estar rodando pois servem apenas
                             para criação de tabelas no banco de dados)
```
docker ps
```
Endereço para acessar a interface do Konga
```
http://localhost:1337/
```
Criar um usuário administrador para acesso ao Konga e realizar conexão ao serviço do Kong
```
1. Informar nome de usuario, email e senha
2. Realizar Login
3. Apontar conexão com o Kong. Ex:name=Kong, KongAdminURL=http://kong:8001 (kong=nome do serviço docker, 8001=porta que esta rodando a api do kong)
```

Iniciar serviço de teste, o serviço que será apontado pela api gateway e também configurado para validação de autenticação com o plugin keu auth.
Ir até a pasta docker-service-go e rodar o seguinte comando.
```
docker-compose up -d
```

Criar um novo serviço Kong para conseguirmos acessar nosso serviço de teste a partir do Kong: MENU -> SERVICES -> + ADD NEW SERVICE
```
1. name = ServiceA
2. protocol = http
3. host = servicea
4. port = 8081
5. path = /
```
Criar nova rota para o serviço Kong criado, na lista de serviços clicar em cima do novo serviço criado, ServiceA, ir em ROUTES -> + ADD ROUTE
```
1. name = RotaA
2. paths = /a 
```
Subir o container docker da api de admin, entre na pasta kong-integration do projeto e rode o seguinte comando.
```
docker-compose up -d
```
## Uso do Swagger do serviço de admin
Entre no seguinte endereço a partir de um navegador.
```
http://localhost:8080/swagger-ui.html
```
### Criar um consumidor
Na pagina inicial do swagger expanda a lista de requests da coleção "Key Auth Resource". Clique no endpoint "Responsável por criar um consumidor", depois no botão "Try It Out", informe o nome do consumidor desejado e clique no botão "Execute".

### Criar validação de autenticação a uma rota
Para criar uma validação de autenticação a rota criada, ou a outra existente qualquer, utilize o endpoint "Responsável por criar validação de autenticação a uma rota" com o seguinte payload.
```
{
    "name": "key-auth",
    "config": {
        "key_names": ["x-api-key"],
        "key_in_header": true,
        "key_in_query": false,
        "key_in_body": false
    },
    "route": {
        "name": "RotaA"
    }
}
```
### Criar uma key de autenticação a um consumidor
No endpoint "Responsável por criar uma key de autenticação a um consumidor" clique em "Try It Out", informe o nome do consumidor já criado e envie a requisição clicando no botão "Execute".

### Deletar uma key de autenticação de um consumidor
Em "Responsável por deletar uma chave de autenticação de um consumidor" clique em "Try It Out", digite o nome do consumidor e o id da chave que deseja deletar.

### Consultar todas chaves de autenticação existentes na base de dados.
Clique no endpoint "Responsável por buscar chaves de autenticação de todos consumidores", depois em "Try It Out" e "Execute".

### Consultar chaves de autenticação de um consumidor específico.
No endpoint "Responsável por buscar chaves de autenticação de um consumidor", clique em "Try It Out", digite o nome do consumidor e depois em "Execute"