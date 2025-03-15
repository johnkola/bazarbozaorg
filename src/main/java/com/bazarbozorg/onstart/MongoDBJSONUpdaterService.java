package com.bazarbozorg.onstart;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

//@Service
public class MongoDBJSONUpdaterService {

    private static final Logger logger = LoggerFactory.getLogger(MongoDBJSONUpdaterService.class);

    private final MongoTemplate mongoTemplate;
    private final JsonSchemaValidator jsonSchemaValidator;
    private final ObjectMapper objectMapper;

    private final Path jsonDirectory;

    public MongoDBJSONUpdaterService(MongoTemplate mongoTemplate,
                                     JsonSchemaValidator jsonSchemaValidator,
                                     ObjectMapper objectMapper,
                                     @Value("${json.folder.path}") String jsonFolderPath) {
        this.mongoTemplate = mongoTemplate;
        this.jsonSchemaValidator = jsonSchemaValidator;
        this.objectMapper = objectMapper;


        try {
            this.jsonDirectory = Path.of(jsonFolderPath);
        } catch (Exception e) {
            throw new RuntimeException("Invalid JSON directory path: " + e.getMessage(), e);
        }
    }

    @PostConstruct
    public void init() {
        logger.info("🚀 Running MongoDB JSON Updater BEFORE web starts...");
        processJSONFiles();
        logger.info("✅ MongoDB JSON Updater Finished.");
    }

    public void processJSONFiles() {
        if (!Files.exists(jsonDirectory) || !Files.isDirectory(jsonDirectory)) {
            logger.error("❌ ERROR: Invalid JSON directory: {}", jsonDirectory);
            return;
        }

        try (Stream<Path> jsonFiles = Files.list(jsonDirectory).filter(path -> path.toString().endsWith(".json"))) {
            jsonFiles.forEach(this::updateMongoDBFromJSON);
            logger.info("✅ All JSON files processed successfully.");
        } catch (Exception e) {
            logger.error("❌ ERROR: Failed to process JSON files: {}", e.getMessage(), e);
        }
    }

    public void updateMongoDBFromJSON(Path jsonFile) {
        String collectionName = jsonFile.getFileName().toString().replaceFirst("\\.[^.]+$", "");

        try {
            List<Document> updates = readJsonFile(jsonFile);

            if (!updates.isEmpty()) {
                mongoTemplate.insert(updates, collectionName);
                logger.info("✅ Updated collection: {}", collectionName);
            } else {
                logger.warn("⚠️ WARNING: No valid records found in {}", jsonFile.getFileName());
            }

        } catch (Exception e) {
            logger.error("❌ ERROR: Failed to process file: {}", jsonFile.getFileName(), e);
        }
    }

    public List<Document> readJsonFile(Path path) {
        try {
            String jsonString = Files.readString(path).trim();
            JsonNode rootNode = objectMapper.readTree(jsonString);

            // Validate JSON Schema
            Set<String> validationErrors = jsonSchemaValidator.validateJson(rootNode.toString());
            if (!validationErrors.isEmpty()) {
                throw new RuntimeException("JSON Schema Validation Errors: " + validationErrors);
            }

            // Convert to MongoDB Documents
            List<Document> documents = new ArrayList<>();
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    documents.add(Document.parse(node.toString()));
                }
            } else {
                throw new RuntimeException("JSON file is not an array: " + path);
            }

            return documents;
        } catch (Exception e) {
            throw new RuntimeException("Failed to read or parse JSON file: " + path, e);
        }
    }
}
