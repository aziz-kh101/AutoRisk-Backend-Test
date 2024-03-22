# VM-API Documentation

## Introduction

This document provides an overview of the API endpoints and their functionalities for the VM-API project.

## Technologies Used

- Spring Boot
- Swagger

## Requirements

1. install `mysql` database or use [docker image](https://hub.docker.com/_/mysql)

1. add `application.properties` under `src/main/resources/`

```
spring.application.name=vm-api
server.port=8080

# Configuration de la source de données
spring.datasource.url=jdbc:mysql://localhost:3306/vms?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

# Configuration de Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# swagger-ui custom path
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.path=/api-docs

# Configuration de la sécurité
token.signing.key=<base64-encoded>
```

you can generate `base64-encoded` key using this [link](https://www.convertsimple.com/random-base64-generator/)

## API Endpoints

run springboot application then open swagger [link](http://localhost:8080/swagger-ui/index.html#/)

> default admin to connect with for test : <br>
> username: admin <br>
> password: 123456
