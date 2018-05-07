package by.bsuir.aipos.springrest.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class HeaderDto {
    @NotBlank
    private String patternName;
    @NotBlank
    private String authorEmail;
}
