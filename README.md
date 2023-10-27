## Used Tecnology
Spring boot 3.1.5
AWS RDS Postgres
JPA
JWT
Lombok

## Technical Debt
Model Bill, field **desc** changed to **description**

# Run project docker by url
**docker build https://github.com/JhonMorales/taxislibres.git#master:. -t taxislibres:spring-boot**

use **docker images**, get **IMAGE ID** and run "docker run -p 8080:8080 -p 5432:5432 -d ***idimage***"

**Success**

Endpoints protecteds by jwt except login(atuhorization bearer) and create user, first create user and after get jwt and execute other endpoints:

## Endpoints

-**Create User**

Method: **POST**
URL: http://localhost:8080/api/user
Body:
```json
{
	"name": "test",
	"email": "taxislibres@gmail.com",
	"age": 24
}
```

-**Authorization bearer**

>This method only valid email, because in the requirements say a User with attributes specific, password is not one of them.

Method: **POST**
URL: http://localhost:8080/login?email=taxislibres@gmail.com&password=test
Body: ***Nothing***

-**User GetById**

>This method require Bearer Token

Method: **GET**
URL: http://localhost:8080/api/user/4
Body: ***Nothing***

-**User GetByEmail**

>This method require Bearer Token

Method: **GET**
URL: http://localhost:8080/api/user?email=ingrejhon@gmail.com
Body: ***Nothing***

-**Bill Create**

>This method require Bearer Token, require user valid, if user not exists return 404

Method: **POST**
URL: http://localhost:8080/api/bill
Body:
```json
{
    "totalAmount": 42.56,
    "description": "test",
    "idUser": 5
}
```

-**Bill GetById**

>This method require Bearer Token

Method: **GET**
URL: http://localhost:8080/api/bill/1
Body: ***Nothing***

-**Bill Update**

>This method require Bearer Token, require user valid, if user not exists return 404

Method: **PUT**
URL: http://localhost:8080/api/bill/2
Body:
```json
{
    "totalAmount": 500,
    "description": "cambio",
    "idUser": 2
}
```
-**Bill Delete**

>This method require Bearer Token

Method: **DELETE**
URL: http://localhost:8080/api/bill/1
Body: ***Nothing***


### Run project manual, download repo
git clone https://github.com/JhonMorales/taxislibres.git
cd taxislibres
mvnw package
docker build . -t spring-boot-taxislibres:spring-docker
docker images and get id spring-boot-taxislibres:spring-docker
docker run -p 8080:8080 -p 5432:5432 -d **idimage**

[Explicación Docker Con Repositorio Manual](https://www.youtube.com/watch?v=D9agLXHBhFc "Guia")