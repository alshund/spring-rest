package by.bsuir.aipos.springrest.controller.converter;

import by.bsuir.aipos.springrest.controller.dto.ArticleDto;
import by.bsuir.aipos.springrest.controller.dto.HeaderDto;
import by.bsuir.aipos.springrest.repository.model.Article;
import by.bsuir.aipos.springrest.repository.model.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;

@Component
public class ArticleConverterImpl implements ArticleConverter {
    @Override
    public Article dtoToModel(ArticleDto articleDto) {

        return Article.builder()
                .author(buildAuthor(articleDto.getHeaderDto()))
                .title(articleDto.getHeaderDto().getPatternName())
                .description(articleDto.getContentDto().getDescription())
                .content(articleDto.getContentDto().getContent())
                .build();

    }

    private Author buildAuthor(HeaderDto headerDto) {

        return Author.builder()
                .email(headerDto.getAuthorEmail())
                .articleList(new HashSet<>())
                .build();
    }


}
