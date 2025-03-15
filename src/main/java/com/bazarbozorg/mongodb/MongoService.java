package com.bazarbozorg.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return mongoClient.getDatabase(databaseName).listCollectionNames().into(new java.util.ArrayList<>());
    }

    public List<Document> findAllDocuments(String databaseName, String collectionName) {
        return mongoClient.getDatabase(databaseName)
                .getCollection(collectionName)
                .find()
                .into(new java.util.ArrayList<>());
    }

    public Document findDocumentByPublicId(String databaseName, String collectionName, UUID publicId) {
        return mongoClient.getDatabase(databaseName)
                .getCollection(collectionName)
                .find(Filters.eq("publicId", publicId))
                .first();
    }

    public void insertDocument(String databaseName, String collectionName, Document document) {
        mongoClient.getDatabase(databaseName)
                .getCollection(collectionName)
                .insertOne(document);
    }
}
