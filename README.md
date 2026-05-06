# Basic Apache Camel Project

A Spring Boot project that uses Apache Camel to read content from a source file and move it to a destination folder. The same route is implemented twice, once in **XML DSL** and once in **Java DSL**, so the two styles can be compared side by side.

## What this demonstrates

- Wiring Apache Camel into a Spring Boot application.
- Defining the same Camel route in two DSLs:
  - **XML DSL** (active by default) in `src/main/resources/camel-routes/routes.xml`
  - **Java DSL** in `FileMoverRoute.java`, activated via the `java-dsl` Spring profile
- File-based integration: reading from one folder and writing to another.

## Tech stack

- Java + Spring Boot
- Apache Camel
- Maven

## Project structure

```
src/main/java/com/camel/apache/apacheCamel
├── ApacheCamelApplication.java   # Spring Boot entry point
└── FileMoverRoute.java           # Camel route in Java DSL (profile: java-dsl)

src/main/resources
├── application.properties
└── camel-routes/routes.xml       # Same route in XML DSL (active by default)
```

## How the route works

Picks up files from `tmp/camel`, logs the body and the file name, and moves the file to `tmp/camel/processed`.

## Run it on your machine

### Prerequisites
- Java 17 or newer (`java -version`)
- No need to install Maven, the project includes the Maven wrapper

### Steps

```bash
# 1. Clone
git clone https://github.com/Haseeb-Khalil/Basic-Apache-Camel-Project.git
cd Basic-Apache-Camel-Project

# 2. Make sure the source folder exists
mkdir -p tmp/camel/processed

# 3. Run (XML DSL is active by default)
./mvnw spring-boot:run
# On Windows:  mvnw.cmd spring-boot:run
```

In another terminal, drop a file into `tmp/camel`:

```bash
echo "Hello Camel" > tmp/camel/test.txt
```

The route picks it up, logs the body, and moves it to `tmp/camel/processed/`.

### Switch to the Java DSL implementation

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=java-dsl
```

## Why I built this

I work with Apache Camel routes day to day at Capgemini on the HMRC Enterprise Integration Services (EIS) programme. This project is a small reference for the two ways of writing Camel routes and the trade-offs between them.
