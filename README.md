## Product API

Basic api created with `quarkus` project.

    References
        
        * https://quarkus.io/guides/getting-started-guide
        * https://quarkus.io/guides/getting-started-testing
        * https://quarkus.io/guides/hibernate-orm-guide
        * https://quarkus.io/guides/rest-json-guide

#### Tech

* Quarkus
* Postgres
* Docker

#### Start Postgres

If you have postgres service running in dev, configure `application.properties` file.

> Run postgres container

```bash
docker run --name=products-api -d -p 5432:5432  -e POSTGRES_PASSWORD=sa -e POSTGRES_USER=sa -e POSTGRES_DB=products-api postgres
```

### Build App

```bash
mvn clean install 
```

### Run Application  

> dev 

```bash
mvn compile quarkus:dev
```

> ENVs

```bash
export DATABASE_URL=jdbc:postgresql://localhost:5432/products-api
export DATABASE_USERNAME=""
export DATABASE_PASSWORD=""
```

> Run jar

```bash
java -jar target/products-api-1.0-SNAPSHOT-runner.jar
```# products-app
