package com.example.backendProject.configuration;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// used when want to create obj of class not own by us.
// RestTemplate class is from springweb
@Configuration
public class ApplicationConfiguration {
    @Value("${razorpay.id}")
    private String razorpayId;
    @Value("${razorpay.secret}")
    private String razorpaySecret;

    @Bean
    public RestTemplate createRestTemplate() {

        return new RestTemplate();
    }
    @Bean
    public RazorpayClient createRazorpayClient() {
        try {
            return new RazorpayClient(razorpayId, razorpaySecret);
        }catch(RazorpayException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
