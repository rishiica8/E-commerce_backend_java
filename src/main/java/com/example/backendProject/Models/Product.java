package com.example.backendProject.Models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Product extends BaseModel implements Serializable {
    private String title;
    private String description;
    private String imageURL;
     @ManyToOne( cascade = CascadeType.ALL)
    private Category category;


}
