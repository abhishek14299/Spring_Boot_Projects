package com.UserApp;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@OpenAPIDefinition(
	info = @Info(
		title="Spring Boot User Application",
		description = "Spring Boot User Application With Documentation",
		version = "V 1.0.0",
		contact = @Contact(
				name = "Abhishek Kushwaha",
				email = "dummy@mail.com",
				url = "http://localhost:8080/user/userData"
		),
			license = @License(
					name = "Apache 2.0",
					url = "http://www.apache.org/licenses/LICENSE-2.0.html"
			)
),
		externalDocs =@ExternalDocumentation(
				description= "Find out more about Swagger",
				url= "http://swagger.io"
		)
)
@SpringBootApplication
public class UserAppApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(UserAppApplication.class, args);
	}

}
