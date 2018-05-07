package by.bsuir.aipos.springrest.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ContentDto {
    @NotBlank
    private String content;
    @NotBlank
    private String description;
}
