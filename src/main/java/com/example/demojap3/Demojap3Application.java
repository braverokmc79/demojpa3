package com.example.demojap3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass =SimpleMyRepository.class)
public class Demojap3Application {
	public static void main(String[] args) {
		SpringApplication.run(Demojap3Application.class, args);
	}

}
