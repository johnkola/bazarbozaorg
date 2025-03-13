package com.bazarbozorg.service;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MongoService {

    private final MongoClient mongoClient;

    @Autowired
    public MongoService(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public List<String> listCollections(String databaseName) {
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        List<String> collections = new ArrayList<>();
        for (String name : database.listCollectionNames()) {
            collections.add(name);
        }
        return collections;
    }

    public List<Document> findAllDocuments(String databaseName, String collectionName) {
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        List<Document> documents = new ArrayList<>();
        for (Document doc : collection.find()) {
            documents.add(doc);
        }
        return documents;
    }

    public Document findDocumentByPublicId(String databaseName, String collectionName, UUID publicId) {
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);

        // Example UUID
        return collection.find(Filters.eq("publicId", publicId)).first();
    }

    public void insertDocument(String databaseName, String collectionName, Document document) {
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);
    }
}
