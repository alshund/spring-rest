package by.bsuir.aipos.springrest.controller.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class ApiResponseBo {

    @NotBlank
    private String message;
}
