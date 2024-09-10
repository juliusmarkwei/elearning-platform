package com.julius.jpa.repositories;

import com.julius.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    //select * from author where first_name = 'julius'
    List<Author> findAllByFirstName(String firstName);

    //select * from author where first_name like '%liu%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    //select * from author where first_name like 'ju%'
    List<Author> findAllByLastNameStartingWith(String lastName);

    //select * from author where first_name like '%ju'
    List<Author> findAllByLastNameEndsWith(String lastName);

    //select * from author where first_name like ('Julius', 'Moriarty', 'Holmes')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);
}
