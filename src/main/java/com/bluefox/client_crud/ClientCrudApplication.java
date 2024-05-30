package com.bluefox.client_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClientCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientCrudApplication.class, args);
	}

}
