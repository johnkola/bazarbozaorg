package com.bazarbozorg.onstart;

import com.bazarbozorg.logging.CustomLoggerFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.networknt.schema.*;
import org.slf4j.Logger;
import org.springframework.core.io.Resource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

public class JsonSchemaValidator {
    private final ObjectMapper objectMapper;
    private final JsonSchema jsonSchema;
    Logger logger = CustomLoggerFactory.getLogger(JsonSchemaValidator.class);

    public JsonSchemaValidator(Resource schemaResource) {
        this.objectMapper = new ObjectMapper();

        try {
            // Read JSON schema from file
            String schemaContent = Files.readString(Path.of(schemaResource.getURI()));
            JsonNode schemaNode = objectMapper.readTree(schemaContent);

            // Load schema with strict validation
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
            SchemaValidatorsConfig config = new SchemaValidatorsConfig();
            this.jsonSchema = schemaFactory.getSchema(schemaNode, config);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON Schema: " + e.getMessage());
        }
    }

    public Set<String> validateJson(String jsonFilePath) {
        try {
            // Read JSON file
            String jsonData = Files.readString(Path.of(jsonFilePath));
            JsonNode jsonNode = objectMapper.readTree(jsonData);

            ArrayNode arrayNode = (ArrayNode) jsonNode;

            arrayNode.iterator().forEachRemaining(node -> {
                logger.info(node.asText());
            });
            // Validate JSON against schema
            Set<ValidationMessage> validationMessages = jsonSchema.validate(jsonNode);


            // Convert validation messages to a set of error strings
            return validationMessages.stream()
                    .map(ValidationMessage::getMessage)
                    .collect(Collectors.toSet());

        } catch (Exception e) {
            throw new RuntimeException("Error processing JSON: " + e.getMessage());
        }
    }
}
