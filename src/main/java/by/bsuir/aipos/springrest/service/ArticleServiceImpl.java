package by.bsuir.aipos.springrest.service;

import by.bsuir.aipos.springrest.repository.ArticleRepository;
import by.bsuir.aipos.springrest.repository.AuthorRepository;
import by.bsuir.aipos.springrest.repository.model.Article;
import by.bsuir.aipos.springrest.repository.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Article> getArticleList() {

        List<Article> articleList = articleRepository.findAll();
        return articleList;
    }

    @Override
    public Article getArticle(String email, String title) throws NoSuchArticleException {

        Optional<Article> article = articleRepository.findByTitleAndAuthor_Email(title, email);
        if (article.isPresent()) {
            return article.get();
        } else {
            throw new NoSuchArticleException();
        }
    }

    @Override
    public void addArticle(Article article) {

        String email = article.getAuthor().getEmail();
        Optional<Author> author = authorRepository.findByEmail(email);
        if (author.isPresent()) {
            article.setAuthor(author.get());
        } else {
            authorRepository.save(article.getAuthor());
        }
        articleRepository.save(article);

    }

    @Override
    public void removeArticle(String email, String title) {

        articleRepository.deleteByTitleAndAuthor_Email(title, email);
//        Optional<List<Article>> articleList = articleRepository.findArticlesByAuthor_Email(email);
//        if (!articleList.isPresent()) {
//            authorRepository.deleteByEmail(email);
//        }
    }

    @Override
    public void updateArticle(String email, String title, Article article) {

    }
}
