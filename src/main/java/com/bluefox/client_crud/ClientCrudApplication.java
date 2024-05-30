package com.bluefox.client_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// import io.swagger.v3.oas.annotations.OpenAPIDefinition;
// import io.swagger.v3.oas.annotations.info.Info;

/**
 * Os módulos selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 * 
 */

@EnableFeignClients
// @OpenAPIDefinition(info = @Info(title = "Client API", version = "1.0.0", description = "Api para gerenciar cadastros de clientes"))
@SpringBootApplication
public class ClientCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientCrudApplication.class, args);
	}

}
