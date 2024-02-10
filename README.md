## README.md

**Project Name:** Java Spring Base

**Author:** [Mohit Arora](https://github.com/imohitarora)

**Description:**

This project is a Spring Boot 3 application built with Java 21 utilizing Maven as the build tool. It implements several key features:

* **Database:** PostgreSQL
* **Authentication:** Spring Security with JWT (JSON Web Token) authentication
* **Auditing:** Aspect-Oriented Programming (AOP) for tracking data changes
* **BaseService Architecture:** Generic CRUD operations for efficient development
* **OpenAPI 3:** Documentation and interaction with APIs using OpenAPI specification

**Technologies:**

* Spring Boot 3
* Java 21
* Maven
* PostgreSQL
* Spring Security
* JWT
* AOP
* OpenAPI 3

**Getting Started:**

1. Clone this repository: `git clone https://github.com/imohitarora/java-springboot-base-template.git`
2. Install PostgreSQL and configure your database connection details in `application.yml`.
3. Ensure you have Maven installed and run `mvn clean install` to build the project.
4. Run the application: `java -jar target/java-spring-base-0.0.1-SNAPSHOT.jar`
5. Access the OpenAPI documentation at `http://localhost:8082/swagger-ui/index.html`.
