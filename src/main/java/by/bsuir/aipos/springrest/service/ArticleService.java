package by.bsuir.aipos.springrest.service;

import by.bsuir.aipos.springrest.repository.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getArticleList();
    Article getArticle(String email, String title) throws NoSuchArticleException;
    void addArticle(Article article);
    void removeArticle(String email, String title);
    void updateArticle(String email, String title, Article article);
}
