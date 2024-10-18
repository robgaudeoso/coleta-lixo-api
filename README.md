# coleta-lixo-api

## Pré-requisitos

-   Java 17
-   Git
-   Docker

# Build

docker build -t api .

# Run

docker run -p 8080:8080 \  
-e PROFILE=prd \
-e DATABASE_URL={DBUrl} \
-e DATABASE_USER={YourDBUserName} \
-e DATABASE_PWD={YourDBPassword} \
api

## Testes unitários

./mvnw test

## Build e execução

sh
docker compose up --build

## Documentação online (OpenAPI)

http://localhost:8080/swagger-ui/index.html

![](/assets/images/swagger.png)
