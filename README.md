mvnw package
docker build . -t spring-boot-taxislibres:spring-docker
docker images and get id spring-boot-taxislibres:spring-docker
docker run -p 8080:8080 -p 5432:5432 -d **idimage**

[Explicación](https://www.youtube.com/watch?v=D9agLXHBhFc "Guia")