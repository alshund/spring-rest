package by.bsuir.aipos.springrest.controller.converter;

import by.bsuir.aipos.springrest.controller.dto.ArticleDto;
import by.bsuir.aipos.springrest.repository.model.Article;

public interface ArticleConverter {

    Article dtoToModel(ArticleDto articleDto);
}
