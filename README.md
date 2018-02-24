![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=ch.ricardo.project%3AToDoList&metric=alert_status)
![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ch.ricardo.project%3AToDoList&metric=coverage)

# ToDoList
a very simply ToDo list

## Prerequisites

* Java 8
* Docker
* Maven 3

## Features
This code provide a very basic REST api for a Simple ToDoList as example, featuring:
* Spring Boot 1.5.10 RELEASE
* Swagger
* Logback
* Metrics configuration
* H2 database
* Maven profiles bind with Spring profiles
* Junit test
* Restassured integration test
* Docker

# How to compile and run

mvn clean install

mvn spring-boot:run

After running you can check the connectivity with a basic Ping call:

http://localhost:8080/ping

And you can try the swagger interface for try the endpoints:

http://localhost:8080/swagger-ui.html

you have also the Spring actuator's endpoints:
/health – Shows application health information (a simple ‘status’ when accessed over an unauthenticated connection or full message details when authenticated); it’s not sensitive by default
/info – Displays arbitrary application info; not sensitive by default
/metrics – Shows ‘metrics’ information for the current application; it’s also sensitive by default
/trace – Displays trace information (by default the last few HTTP requests)
more here: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#production-ready-endpoints

No authentication are provide for this version