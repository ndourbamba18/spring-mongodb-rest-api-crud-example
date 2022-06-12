# spring-mongodb-rest-api-crud-example

# E-Commerce Api Rest using Spring Boot & JWT Authentication with Spring Security & Spring Data JPA & Contact Form

## Backend Authentication

> [Spring Boot + JWT Authentication + MySQL](https://github.com/ndourbamba18/user-registration-jwt-api-rest)

## Backend CRUD App

> [Spring Boot + MySQL Example Company Service App](https://github.com/ndourbamba18/company-service)

> [Spring Boot + Spring MVC + MySQL Example Employee Manager App ](https://github.com/ndourbamba18/spring-boot-mvc-employee-manager)

> [Spring Boot + Java Mail Sender Example Contact Form](https://github.com/ndourbamba18/contact-form)

> [Spring Boot + MySQL Example Training App](https://github.com/ndourbamba18/training-rest-api)

## Microservices:
> [Spring Boot + MySQL + Rest Template](https://github.com/ndourbamba18/Microservices)
 
> [Spring Boot + MySQL + Open Feign](https://github.com/ndourbamba18/SpringBoot-Microservices-Using-FeignClients)

> [Spring Boot + MySQL + Rest Template](https://github.com/ndourbamba18/spring-boot-rest-template)

More Practice:
> [Spring Boot + MySQL Example Microservice](https://github.com/ndourbamba18/SpringBoot-Microservices)

>  [Django + SQlite3 Example Login and Registration User](https://github.com/ndourbamba18/login-registration-app)

> [Spring Boot + MySQL Example Customer App](https://github.com/ndourbamba18/customer-app)

## Dependency
– If you want to use PostgreSQL:
```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>
```
– or MySQL:
```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <scope>runtime</scope>
</dependency>

- JWT
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>
   
- Faker for github

		<dependency>
			<groupId>com.github.javafaker</groupId>
			<artifactId>javafaker</artifactId>
			<version>1.0.1</version>
		</dependency>
    
- mindrot

   <dependency>
	<groupId>org.mindrot</groupId>
	<artifactId>jbcrypt</artifactId>
	<version>0.3m</version>
 </dependency>
 ```  
### Configure Spring Datasource, JPA, App properties
Open `src/main/resources/application.properties`
- For PostgreSQL:
```
spring.datasource.url= jdbc:postgresql://localhost:5432/ecommercedb
spring.datasource.username= postgres
spring.datasource.password= your password
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation= true
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto= update
spring.jackson.serialization.fail-on-empty-beans=false
spring.main.allow-circular-references=true

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username='Your email_address (example : ndourcodeur@gmail.com)'
spring.mail.password='Your password (example : hello@2021)'
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
jwt.secret=secret
```
- For MySQL
```
server.port=8080
jwt.secret=secret
spring.datasource.url = jdbc:mysql://localhost:3306/ecommercedb?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username = username
spring.datasource.password = your Password
spring.datasource.platform=mysql
spring.datasource.initialization-mode=always
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto = update
spring.jackson.serialization.fail-on-empty-beans=false
spring.main.allow-circular-references=true

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username='Your email_address (example : ndourcodeur@gmail.com)'
spring.mail.password='Your password (example : hello@2021)'
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=5000
spring.mail.properties.mail.smtp.writetimeout=5000
```

## Download All Package :
```
mvn package
```
## Run Spring Boot application
```
mvn spring-boot:run
```

## An others Branches

> [commandLineRunner](https://github.com/ndourbamba18/ecommerce-spring-api-rest/tree/commandLineRunner)

> [docker-compose](https://github.com/ndourbamba18/ecommerce-spring-api-rest/tree/docker-compose)


