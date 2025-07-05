package com.example.backendProject.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateProductRequestDTO {
    private String title;
    private String description;
    private String imageURL;
    private CategoryRequestDTO category;

}
