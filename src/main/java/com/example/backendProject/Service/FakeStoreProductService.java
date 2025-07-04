package com.example.backendProject.Service;

import com.example.backendProject.DTO.FakeStoreResponseDTO;
import com.example.backendProject.Models.Category;
import com.example.backendProject.Models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getProductById(Integer id) {
        Product product = new Product();

        // 1. Call Fakestore API --> Use RestTemplate.
        ResponseEntity<FakeStoreResponseDTO> fakeStoreResponse =
                restTemplate.getForEntity("https://fakestoreapi.com/products/" + id, FakeStoreResponseDTO.class);
        // we'll have to create a class which represent fakestore obj and that is dto.

        // 2. Get the response
        FakeStoreResponseDTO response = fakeStoreResponse.getBody();
        if (response == null) {
            throw new IllegalArgumentException("FakeStoreProduct not found!!");
        }

        //3. Convert the response to product model
        product = convertFakeStoreResponseToProduct(response);
        return product;
    }

    private Product convertFakeStoreResponseToProduct(FakeStoreResponseDTO response) {
        Product product = new Product();
        Category category = new Category();
        category.setTitle(response.getCategory());

        product.setId(response.getId());
        product.setCategory(category);
        product.setDescription(response.getDescription());
        product.setImageURL(response.getImage());
        product.setTitle(response.getTitle());

        return product;
    }
    public List<Product> getAllProducts(){
        List<Product> response = new ArrayList<>();
        ResponseEntity<FakeStoreResponseDTO[]> FakeStoreResponse =
                restTemplate.getForEntity("https://fakestoreapi.com/products/",FakeStoreResponseDTO[].class);
        System.out.println("Status Code : " + FakeStoreResponse.getStatusCode());
       // now converting the response
        for (FakeStoreResponseDTO fakestoreDTO : FakeStoreResponse.getBody()) {
            response.add(convertFakeStoreResponseToProduct(fakestoreDTO));
        }

        return response;



    }

    public Product createProduct(String title, String imageURL, String catTitle, String description){
        return null;
    }
}
