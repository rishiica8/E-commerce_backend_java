package com.example.backendProject.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// used when want to create obj of class not own by us.
// RestTemplate class is from springweb
@Configuration
public class ApplicationConfiguration {
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
