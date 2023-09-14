package com.desafio.vmbears;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.desafio.vmbears")
@EntityScan(basePackages = "com.desafio.vmbears.entities")
public class VmbearsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmbearsApplication.class, args);
	}

}
