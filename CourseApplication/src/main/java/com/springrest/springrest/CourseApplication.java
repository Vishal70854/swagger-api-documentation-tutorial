package com.springrest.springrest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Course Application OPEN API",
				version = "1.0.0",
				description = "Course Application OPEN API DOCUMENTATION"
		),
		servers = @Server(
				url = "http://localhost:8080",
				description = "Course Application OPEN API"
		)
)
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

}
