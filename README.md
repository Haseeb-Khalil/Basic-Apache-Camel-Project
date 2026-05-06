# Basic Apache Camel Project

A Spring Boot project that uses Apache Camel to read content from a source file and move it to a destination folder. The same route is implemented twice, once in **Java DSL** and once in **XML DSL**, so the two styles can be compared side by side.

## What this demonstrates

- Defining Apache Camel routes in Java DSL using `RouteBuilder`.
- Defining the same route in XML DSL through a Spring Camel context.
- Wiring Camel into a Spring Boot application.
- File-based integration: reading from one folder and writing to another.

## Tech stack

- Java + Spring Boot
- Apache Camel
- Maven

## Project structure

```
src/main/java/com/camel/apache/apacheCamel
├── ApacheCamelApplication.java   # Spring Boot entry point
└── FileMoverRoute.java           # Camel route in Java DSL

src/main/resources
├── application.properties
└── camel-routes/routes.xml       # Same route in XML DSL
```

## How it works

The route picks up files from a source directory, logs the content and moves them into a target directory. The Java DSL version lives in `FileMoverRoute.java`. The XML DSL version lives in `src/main/resources/camel-routes/routes.xml`.

## Running it locally

```bash
git clone https://github.com/Haseeb-Khalil/Basic-Apache-Camel-Project.git
cd Basic-Apache-Camel-Project
./mvnw spring-boot:run
```

Source and target folder paths are configured in `application.properties`.

## Why I built this

I work with Apache Camel routes day to day at Capgemini on the HMRC Enterprise Integration Services (EIS) programme. This project is a small reference for the two ways of writing Camel routes and the trade-offs between them.
