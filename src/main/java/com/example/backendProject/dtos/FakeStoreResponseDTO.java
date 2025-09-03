package com.example.backendProject.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private String category;
    private String imageUrl;
}
