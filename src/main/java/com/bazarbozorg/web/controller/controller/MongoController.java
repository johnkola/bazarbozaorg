package com.bazarbozorg.web.controller.controller;


import com.bazarbozorg.mongodb.MongoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mongo")
@Tag(name = "MongoDB Controller", description = "API Endpoints for MongoDB Operations")
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @Operation(summary = "List collections in a database")
    @GetMapping("/collections/{database}")
    public List<String> getCollections(@PathVariable String database) {
        return mongoService.listCollections(database);
    }

    @Operation(summary = "Find all documents in a collection")
    @GetMapping("/documents/{database}/{collection}")
    public List<Document> getDocuments(
            @PathVariable String database,
            @PathVariable String collection) {


        return mongoService.findAllDocuments(database, collection);
    }

    @Operation(summary = "Find a document in a collection by publicId")
    @GetMapping("/documents/{database}/{collection}/{publicId}")
    public Document getDocument(
            @PathVariable String database,
            @PathVariable String collection,
            @PathVariable UUID publicId) {
        Document doc = mongoService.findDocumentByPublicId(database, collection, publicId);
        return doc;
    }


    @Operation(summary = "Insert a new document into a collection")
    @PostMapping("/documents/{database}/{collection}")
    public String insertDocument(
            @PathVariable String database,
            @PathVariable String collection,
            @RequestBody Document document) {
        mongoService.insertDocument(database, collection, document);
        return "Document inserted successfully!";
    }
}
