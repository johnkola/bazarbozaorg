package com.bazarbozorg.core;

import com.bazarbozorg.onstart.JsonSchemaValidator;
import com.bazarbozorg.web.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.file.Path;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AppConfig.class) // Explicitly load AppConfig
@TestPropertySource(locations = "classpath:application-test.yml")
@ExtendWith(SpringExtension.class)
class TypeListJsonValidationTest {

    @Autowired
    private JsonSchemaValidator validator;

    @Value("classpath:test-jsons/local.json")
    private Resource validLocalJson;

    @Value("classpath:test-jsons/role.json")
    private Resource validRoleJson;

    @Value("classpath:test-jsons/invalid.json")
    private Resource invalidJson;

    @Value("classpath:test-jsons/missing_fields.json")
    private Resource missingFieldsJson;

    private Path getJsonFilePath(Resource resource) throws Exception {
        return Path.of(resource.getURI());
    }

    @BeforeEach
    void setup() {
        assertNotNull(validator, "JsonSchemaValidator bean should be auto-wired");
    }

    @Test
    void testValidJsonForLocal() throws Exception {
        Path validJsonPath = getJsonFilePath(validLocalJson);
        Set<String> errors = validator.validateJson(validJsonPath.toString());

        assertTrue(errors.isEmpty(), "Expected valid JSON, but got validation errors: " + errors);
    }

    @Test
    void testValidJsonForRole() throws Exception {
        Path validJsonPath = getJsonFilePath(validRoleJson);
        Set<String> errors = validator.validateJson(validJsonPath.toString());

        assertTrue(errors.isEmpty(), "Expected valid JSON, but got validation errors: " + errors);
    }

    @Test
    void testInvalidJson() throws Exception {
        Path invalidJsonPath = getJsonFilePath(invalidJson);
        Set<String> errors = validator.validateJson(invalidJsonPath.toString());

        errors.forEach(System.out::println);
        assertFalse(errors.isEmpty(), "Expected validation errors but got none.");
    }

    @Test
    void testMissingRequiredFields() throws Exception {
        Path missingFieldsJsonPath = getJsonFilePath(missingFieldsJson);
        Set<String> errors = validator.validateJson(missingFieldsJsonPath.toString());

        errors.forEach(System.out::println);

        assertFalse(errors.isEmpty(), "Expected validation errors but got none.");
        assertTrue(errors.contains("$[0].updateOne.filter: is missing but it is required"), "Expected missing updateOne error.");
    }
}
