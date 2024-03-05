package br.com.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API-LOJA DE ELETRÔNICOS",
			version = "1.0",
			description = "Documentando uma API para loja de eletrônicos",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class LojaEletroApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaEletroApplication.class, args);
	}

}
