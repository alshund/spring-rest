package by.bsuir.aipos.springrest.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ArticleDto {
    @NotNull
    private HeaderDto headerDto;
    @NotNull
    private ContentDto contentDto;
}
