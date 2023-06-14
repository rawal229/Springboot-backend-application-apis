package com.BlogAppApis.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;
    @NotBlank
    @Size(min = 4, message = "Minimum size of category title is 4 or above !!")
    private String categoryTitle;
    @NotBlank
    @Size(min = 15, message = "Minimum size of category description is 15 or above !!")
    private String categoryDescription;
}
