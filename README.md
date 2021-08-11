# kong-key-auth

## Requisitos
  - docker
  - docker-compose
  - postman (opcional)

## Instalação
Criar network para os containers dockers
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
Verificar containers online (imagens que devem estar online kong:2.5.0-alpine, pantsel/konga:latest, postgres:9.5, as migrations não devem estar aparecendo pois servem apenas
                             para criação de tabelas no banco de dados)
```
docker ps
```
Endereço para acessar a interface do Konga
```
http://localhost:1337/
```
Criar usuário de acesso ao Konga
```
- Informar nome de usuario, email e senha
- Realizar Login
- Apontar conexão com o Kong (name=Kong, KongAdminURL=http://kong:8001 (kong=nome do serviço docker, 8001=porta que esta rodando a api kong))
```
Criar novo serviço Kong menu -> services -> + add new service
```
- name = ServiceA
- protocol = http
- host = servicea
- port = 8081
- path = /
```
Criar nova rota para o serviço Kong criado, na lista de serviços clicar em cima do novo serviço, ServiceA, ir em routes, + ADD ROUTE
```
- 
 
```
