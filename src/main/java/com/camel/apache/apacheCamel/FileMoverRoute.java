package com.camel.apache.apacheCamel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * File-mover route in Java DSL.
 *
 * Active when the "java-dsl" Spring profile is enabled. By default the project
 * runs with the equivalent XML DSL route in src/main/resources/camel-routes/routes.xml,
 * so the two implementations can be compared side by side.
 *
 * Run with Java DSL:
 *   ./mvnw spring-boot:run -Dspring-boot.run.profiles=java-dsl
 */
@Component
@Profile("java-dsl")
public class FileMoverRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:tmp/camel?noop=false")
                .log("Java DSL picked up file: ${header.CamelFileName}, body: ${body}")
                .to("file:tmp/camel/processed");
    }
}
