package com.quiz.quizservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class CorssConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8081") // Add the URL of the Quiz Service
                .allowedMethods("GET", "POST") // Add the allowed HTTP methods
                .allowedHeaders("*"); // Add the allowed headers
    }
}
