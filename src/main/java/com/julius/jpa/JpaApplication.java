package com.julius.jpa;

import com.github.javafaker.Faker;
import com.julius.jpa.models.Author;
import com.julius.jpa.repositories.AuthorRepository;
import com.julius.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthorRepository authorRepository, VideoRepository videoRepository) {

        return args -> {
            for (int i = 0; i < 50; i++) {
                Faker faker = new Faker();

                var author = Author.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .age(faker.number().numberBetween(19, 50))
                        .email("contact" + i + 1 + "@gmail.com")
                        .build();
                authorRepository.save(author);
            }

            //update author with ID = 1
            var author = Author.builder()
                    .id(1)
                    .firstName("Julius")
                    .lastName("Markwei")
                    .age(24)
                    .email("juliusmarkwei@gmail.com")
                    .build();
            authorRepository.save(author);

            //update Author a set a.age = 22 where a.id = 1
//            authorRepository.updateAuthor(22, 1);

            //update Author a set a.age = :age
            authorRepository.updateAllAuthorsAges(99);

           /*var video = Video.builder()
                    .name("abc")
                    .length(5)
                    .build();
            videoRepository.save(video);*/
        };
    }

}
