package com.example.backendProject.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private String category;
    private String imageUrl;
}
