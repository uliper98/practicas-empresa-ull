# Kaizten Blue Task

`mvn spring-boot:run`

# Kaizten Red Task

`mvn spring-boot:run`

# Kaizten Algorithm

## Deploy

The REST API is deployed by means of the docker-compose.yml available in the repo:

`docker-compose up`

It takes a while!

Once the API is deployed it can be accessed as follows:

```
curl http://localhost:8080/v1/labels
```  

## Stop

`Ctrl + C`

