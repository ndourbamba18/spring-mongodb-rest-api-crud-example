# Building a Rest Api using Spring Boot and MongoDB

### E-Commerce Backend Application using Spring Boot & MySQL and Spring Data JPA & JWT

> [E-Commerce Rest Api Backend App](https://github.com/ndourbamba18/ecommerce-spring-api-rest)

## Crud Rest Api using Spring Boot & MongoDB

> [Spring Boot + MongoDB](https://github.com/ndourbamba18/spring-mongodb-rest-api-crud-example)


## Backend Authentication

> [Spring Boot + JWT Authentication + MySQL](https://github.com/ndourbamba18/user-registration-jwt-api-rest)

## Backend CRUD App

> [Spring Boot + MySQL Example Company Service App](https://github.com/ndourbamba18/company-service)

> [Spring Boot + Spring MVC + MySQL Example Employee Manager App ](https://github.com/ndourbamba18/spring-boot-mvc-employee-manager)

> [Spring Boot + Java Mail Sender Example Contact Form](https://github.com/ndourbamba18/contact-form)

> [Spring Boot + MySQL Example Training App](https://github.com/ndourbamba18/training-rest-api)

> [Aws amazon lambda using Spring Boot](https://github.com/ndourbamba18/aws-amazon-lambda-backend-using-spring-boot)

## Front End

> [Angular Basic Example](https://github.com/ndourbamba18/angular-app)

> [Frontend App With Angular](https://github.com/ndourbamba18/aws-amazon-lambda-using-angular)

## Microservices:
> [Spring Boot + MySQL + Rest Template](https://github.com/ndourbamba18/Microservices)
 
> [Spring Boot + MySQL + Open Feign](https://github.com/ndourbamba18/SpringBoot-Microservices-Using-FeignClients)

> [Spring Boot + MySQL + Rest Template](https://github.com/ndourbamba18/spring-boot-rest-template)

### More Practice:

> [Spring Boot + MySQL Example Microservice](https://github.com/ndourbamba18/SpringBoot-Microservices)

>  [Django + SQlite3 Example Login and Registration User](https://github.com/ndourbamba18/login-registration-app)

> [Spring Boot + MySQL Example Customer App](https://github.com/ndourbamba18/customer-app)

# Building a REST API using Spring Boot & MongoDB
![Capture](https://miro.medium.com/max/1400/1*q5l_fHMobLFDNKy2A2Hjqw.png)
In this tutorial we are going to learn how to build a simple crud rest api backend application using Spring Boot and MongoDB.

### What is MongoDB?
MongoDB is a document-oriented NoSQL database that stores JSON-like documents with dynamic schemas. It is commonly used for
high-volume data storage.
Few advantages of a NoSQL database over a SQL database are listed below;
Schemaless
No complex joins.
Ease of scale-out − NoSQL databases are easy to scale.
Conversion/mapping of application objects to database objects not needed.
Uses internal memory for storing the (windowed) working set, enabling faster access to data.

### What is Spring boot?
Spring Boot is an open-source popular Java-based framework for building web and enterprise applications maintained by a company
called Pivotal. Spring boot reduces lots of development time and increases productivity. It has many advantages & with its help, it is
easier to avoid writing lots of boilerplate Code, Annotations, and XML Configuration. It also has a built-in configuration for Spring
JDBC, Spring ORM, Spring Data, Spring Security, etc.

### Prerequisites
In order to complete this tutorial, you should have knowledge of beginner or intermediate Java 8 programming skills, some familiarity with Spring Boot, and also you should have a general familiarity with the Windows command prompt.

#### Tools Used in this Tutorial
- Java 11
- Spring Boot 2.6.6
- Maven
- Lombok
- MongoDB 5.0
- Postman

# Step 1.Spring boot Project Setup
We start working by creating a new project using spring initializr. We will make use of the Spring Initializr tool for quickly setting up the project. Don’t forget to add the dependencies Spring WEB & Spring Data MongoDB.  
![Capture](file:///C:/Users/ndour/Documents/spring-boot-mongodb.svg)

## All Dependencies

- Spring Data MongoDB
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```
- Spring Web
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
- Lombok
```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>
``` 
- dev tools
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <scope>runtime</scope>
  <optional>true</optional>
</dependency>
```
- Spring Validator
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
 ```  
### Configure Spring Datasource, MongoDB, App properties
Open `src/main/resources/application.properties`
- For application.properties:
```
# MongoDB
spring.data.mongodb.host=[host]
spring.data.mongodb.port=[port]
spring.data.mongodb.username=[username]
spring.data.mongodb.password=[password]
spring.data.mongodb.database=[database_name]
spring.application.name=[Your Application Name]
spring.banner.charset=[UTF-8]
# logging
logging.level.org.springframework.data=debug
logging.level.=error
```
- For application.yml
```
spring:
  data:
     mongodb:
        authentication-database: admin
        port: 27017
        host: localhost
        database: EmployeeBackend
  application:
     name: employee-rest-api

  banner:
    charset: UTF-8
 logging:
   level: error 
      org:
         springframework:
            data: debug
```

## Download All Packages
```
mvn package
```

## Running the Project and Testing with Postman
Now let’s test our API calls using postman. Right-click on the project and select Run as a Spring boot App.

## Run Spring Boot application
```
mvn spring-boot:run
```

### Postman
Testing With Postman

## Others Branches

> [master](https://github.com/ndourbamba18/ecommerce-spring-api-rest/tree/commandLineRunner)

> [docker-compose-demo](https://github.com/ndourbamba18/ecommerce-spring-api-rest/tree/docker-compose)

> [Swagger-demo](https://github.com/ndourbamba18/ecommerce-spring-api-rest/tree/commandLineRunner)
