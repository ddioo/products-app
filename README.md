## Product API

 API to create/read/update/delete products (`/products`)

### Tech

* Quarkus
* H2
* Docker
* Java 8

 ### References
        
##### https://quarkus.io/guides/getting-started-guide
##### https://quarkus.io/guides/hibernate-orm-guide
#####  https://quarkus.io/guides/rest-json-guide


### Build App

```bash
mvn clean install 
```

### Run Application  

> dev 

```bash
mvn compile quarkus:dev
```

> Run jar

```bash
java -jar target/products-app-main-1.0-SNAPSHOT-runner.jar
```


### Image of project on docker hub

https://hub.docker.com/layers/borysova/myrepository/latest/images/sha256-ae876f02c52c14d1942b4db103b2f6f8a81dd8279639b288a85317bcc24b461d?context=repo

### Examples

#####API requests sent with Postman 
#####content-type: application/json


##### GET

##### http://localhost:8080/products

```bash
List of all products in JSON:

[{"description":"Rock climbing, ice climbing, mountaineering","id":1,"name":"Helmet","price":60.00},
{"description":"Versatile gloves for rope manipulation","id":2,"name":"Gloves","price":32.00},
{"description":"The ideal solution to carry everything you need for any adventure","id":3,"name":"Backpack","price":155.00}]
```



##### PUT

###### http://localhost:8080/products/products/1

```bash
Body:
     {
       "description": "Rock climbing, ice climbing, mountaineering",
       "id": 1,
       "name": "Helmet",
       "price": 10
     }

Response - modified product.

http://localhost:8080/products/products/1 will return project with modified price:

{"description":"Rock climbing, ice climbing, mountaineering","id":1,"name":"Helmet","price":10.00}
```


##### GET 
/products/{id}

http://localhost:8080/products/5

```bash
Retrieve product by id:

{"description":"Used to climb up on on fixed rope","id":5,"name":"Ascender","price":48.00}
```

##### DELETE 
##### /products/{id}

###### http://localhost:8080/products/4
```bash
After requesting products with "id":4 will cause exceptionProductNotFound: Product not found

http://localhost:8080/products will return list without product "id":4
```



##### POST

###### http://localhost:8080/products


```bash
Body:
{"description":"Climbing chalk bag","name":"Bag","price":19.00}

```


##### GET 

##### http://localhost:8080/products

```bash
In response will be added a new product:

{"description": "Climbing chalk bag", "id": 9, "name": "Bag", "price": 19}


```


