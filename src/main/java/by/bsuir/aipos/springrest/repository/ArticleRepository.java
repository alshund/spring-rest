package by.bsuir.aipos.springrest.repository;

import by.bsuir.aipos.springrest.repository.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findByTitleAndAuthor_Email(String title, String authorEmail);
    Optional<List<Article>> findArticlesByAuthor_Email(String email);
    void deleteByTitleAndAuthor_Email(String title, String email);
}
