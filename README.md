# Run project docker by url
**docker build https://github.com/JhonMorales/taxislibres.git#master:. -t taxislibres:spring-boot**

use **docker images**, get **IMAGE ID** and run "docker run -p 8080:8080 -p 5432:5432 -d ***idimage***"

**Success**

#### Run project manual, download repo
git clone https://github.com/JhonMorales/taxislibres.git
cd taxislibres
mvnw package
docker build . -t spring-boot-taxislibres:spring-docker
docker images and get id spring-boot-taxislibres:spring-docker
docker run -p 8080:8080 -p 5432:5432 -d **idimage**

[Explicación Docker Con Repositorio Manual](https://www.youtube.com/watch?v=D9agLXHBhFc "Guia")