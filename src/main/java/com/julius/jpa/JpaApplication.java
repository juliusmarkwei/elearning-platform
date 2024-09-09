package com.julius.jpa;

import com.julius.jpa.models.Author;
import com.julius.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    //@Bean
    public CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
        return args -> {
            var author = Author.builder()
                    .firstName("Julius")
                    .lastName("Markwei")
                    .age(19)
                    .email("juliusmarkwei@gmail.com")
                    .build();
            authorRepository.save(author);
        };
    }

}
