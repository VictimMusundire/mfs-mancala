package com.mfs.configs;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "MFS - Assignment Backend Documentation",
                description = "Spring Boot REST API Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Victim",
                        email = "mvpvictim@gmail.com",
                        url = "https://www.victim.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.victim.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Mancala or Kalaha game Documentation - MFS",
                url = "https://www.victim.com"
        )
)
public class SpringDocConfig {
}