# My Project General

## Meu projeto de backend em Java utilizando Spring-Boot

### Pré-requisitos

Antes de começar você vai precisar ter instalado na sua máquina
as seguinte ferramentas:

- [Git](https://git-scm.com)
- [Java]()

### Rodando o Backend

```bash
# Criar a imagem do banco
$ docker build -t backoffice-db .
# Executar container do banco de dados MYSQL
$ docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456
$ -e MYSQL_DATABASE=project_general
# Se utilizar usuário root, ... a próxima linha
$ -e MYSQL_USER=main -e MYSQL_PASSWORD=123456
$ backoffice-db
```

> **-d** executa o container no modo desanexado, em segundo plano
> <br> **-p 3306:3306** mapeia a porta 3306 do host para a porta 3306 do aplicativo

Abaixo as especificações das variáveis de ambiente.

> **-e MYSQL_ROOT_PASSWORD** senha para acessar o banco de dados dentro do container
> <br> **-e MYSQL_DATABSE** banco de dados que será criado
> <br> **-e MYSQL_USER** usuário para ter acesso ao bando de dados
> <br> **-e MYSQL_PASSWORD** senha do usuário para ter acesso ao banco de dados

> **backoffice-db** a imagem que será executado no container.

## Usando outro Dockerfile

Caso deseje criar a imagem utilizando outro dockerfile com um nome customizado, utilize a seguinte padrão:

```bash
# docker build -t <tag-name> . -f <file-name>
$ docker build -t backoffice-db . -f Dockerfile-mysql
```

## Acessar manualmente o banco

Para acessar o banco de dados após ter executado o container execute os comandos a seguir:

```bash
# Execute para obter o id do container
$ docker ps
$ docker exec -it <CONTAINER_ID> bash
$ mysql -uroot -p
# Em seguida informe a senha definida anteriormente
```

## Remover container

Se houver container em execução é preciso pará-los antes de excluí-los.

```bash
# Para todos os containers em execução
$ docker stop $(docker ps -a -q)
# Remove todos os containers
$ docker rm $(docker ps -a -q)
```

> **docker ps** lista os containers
> <br> **-a** opção para todos os containers mesmo os parados
> <br> **-q** opção silenciosa para obter apenas os IDs numéricos dos containers
