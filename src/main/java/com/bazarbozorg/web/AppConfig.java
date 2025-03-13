package com.bazarbozorg.web;


import com.bazarbozorg.onstart.JsonSchemaValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public JsonSchemaValidator jsonSchemaValidator(@Value("${json.schema.path}") Resource schemaResource) {
        return new JsonSchemaValidator(schemaResource);
    }
}
