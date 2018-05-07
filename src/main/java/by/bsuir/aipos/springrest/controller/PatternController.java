package by.bsuir.aipos.springrest.controller;

import by.bsuir.aipos.springrest.controller.bo.ApiResponseBo;
import by.bsuir.aipos.springrest.controller.converter.ArticleConverter;
import by.bsuir.aipos.springrest.controller.dto.ArticleDto;
import by.bsuir.aipos.springrest.repository.model.Article;
import by.bsuir.aipos.springrest.service.ArticleService;
import by.bsuir.aipos.springrest.service.NoSuchArticleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patterns")
public class PatternController {

    @Autowired
    private ArticleConverter articleConverter;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public ResponseEntity<?> getArticleList() {

        List<Article> articleList = articleService.getArticleList();
        return ResponseEntity.ok(articleList);
    }

    @GetMapping("/{email}/{title}")
    public ResponseEntity<?> getArticle(@PathVariable("email") String email, @PathVariable("title") String title) {

        try {
            Article article = articleService.getArticle(email, title);
            return ResponseEntity.ok(article);
        } catch (NoSuchArticleException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addArticle(@RequestBody ArticleDto articleDto) {

        Article article = articleConverter.dtoToModel(articleDto);
        articleService.addArticle(article);
        return ResponseEntity.ok(new ApiResponseBo("Article added"));
    }

    @DeleteMapping("/{email}/{title}")
    public ResponseEntity<?> removeArticle(@PathVariable("email") String email, @PathVariable("title") String title) {

        articleService.removeArticle(email, title);
        return ResponseEntity.ok(new ApiResponseBo("Article deleted"));
    }

    @PutMapping("/{email}/{title}")
    public ResponseEntity<?> updateArticle(@PathVariable("email") String email, @PathVariable("title") String title,
                                           @RequestBody ArticleDto articleDto) {

        articleService.updateArticle(email, title, articleConverter.dtoToModel(articleDto));
        return ResponseEntity.ok(new ApiResponseBo("Article updated"));
    }
}
