package com.bazarbozorg.core;

import com.bazarbozorg.onstart.JsonSchemaValidator;
import com.bazarbozorg.onstart.MongoDBJSONUpdaterService;
import com.bazarbozorg.web.AppConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = AppConfig.class) // Explicitly load AppConfig
@TestPropertySource(locations = "classpath:application-test.yml")
@ExtendWith(MockitoExtension.class)
class MongoDBJSONUpdaterServiceTest {

    @Mock
    private MongoTemplate mongoTemplate; // Mocked MongoDB

    @Autowired
    private JsonSchemaValidator jsonSchemaValidator;

    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private MongoDBJSONUpdaterService mongoDBJSONUpdaterService;

    @Value("classpath:data/json-files/valid.json")
    private String validJsonFile;

    @Value("classpath:data/json-files/invalid.json")
    private String invalidJsonFile;

    @Value("classpath:data/json-files/missing_fields.json")
    private String missingFieldsJsonFile;

    private Path getJsonFilePath(String resource) throws Exception {
        return Path.of(resource);
    }

    @BeforeEach
    void setup() {
        mongoDBJSONUpdaterService =
                new MongoDBJSONUpdaterService(mongoTemplate, jsonSchemaValidator, objectMapper, validJsonFile);
    }

    @Test
    void testReadJsonFile_ValidFile() throws Exception {
        Path filePath = getJsonFilePath(validJsonFile);

        List<Document> documents = mongoDBJSONUpdaterService.readJsonFile(filePath);
        assertNotNull(documents);
        assertFalse(documents.isEmpty(), "Valid JSON file should not be empty");
    }

    @Test
    void testReadJsonFile_InvalidJson() throws Exception {
        Path filePath = getJsonFilePath(invalidJsonFile);

        when(jsonSchemaValidator.validateJson(filePath.toString())).thenReturn(Set.of("Invalid JSON format"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            mongoDBJSONUpdaterService.updateMongoDBFromJSON(filePath);
        });

        assertTrue(exception.getMessage().contains("Invalid JSON format"), "Expected invalid JSON format error");
    }

    @Test
    void testReadJsonFile_MissingRequiredFields() throws Exception {
        Path filePath = getJsonFilePath(missingFieldsJsonFile);

        when(jsonSchemaValidator.validateJson(filePath.toString())).thenReturn(Set.of("$[0].updateOne.filter: is missing"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            mongoDBJSONUpdaterService.updateMongoDBFromJSON(filePath);
        });

        assertTrue(exception.getMessage().contains("$[0].updateOne.filter: is missing"), "Expected missing required field error");
    }

    @Test
    void testUpdateMongoDBFromJSON() throws Exception {
        Path jsonFile = getJsonFilePath(validJsonFile);

        when(jsonSchemaValidator.validateJson(jsonFile.toString())).thenReturn(Set.of()); // No errors

        doNothing().when(mongoTemplate).insert(anyList(), anyString());

        mongoDBJSONUpdaterService.updateMongoDBFromJSON(jsonFile);

        verify(mongoTemplate, times(1)).insert(anyList(), eq("valid"));
    }
}
