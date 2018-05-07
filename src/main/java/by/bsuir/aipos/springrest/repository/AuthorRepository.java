package by.bsuir.aipos.springrest.repository;

import by.bsuir.aipos.springrest.repository.model.Article;
import by.bsuir.aipos.springrest.repository.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByEmail(String email);
    void deleteByEmail(String email);
}
