package com.julius.jpa.repositories;

import com.julius.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.courses WHERE a.age >= :age")
    List<Author> findByNamedQuery(@Param("age") Integer age);


    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    void updateAuthor(Integer age, Integer id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(Integer age);


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
