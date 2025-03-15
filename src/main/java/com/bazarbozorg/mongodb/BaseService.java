package com.bazarbozorg.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<T> {

    protected final BaseRepository<T> repository;
    protected final MongoClient mongoClient;

    public BaseService(BaseRepository<T> repository, MongoClient mongoClient) {
        this.repository = repository;
        this.mongoClient = mongoClient;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public Optional<T> getById(UUID id) {
        return repository.findById(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public MongoCollection<T> getMongoCollection(String collectionName, Class<T> clazz) {
        MongoDatabase database = mongoClient.getDatabase(getDatabaseName());
        return database.getCollection(collectionName, clazz);
    }

    private String getDatabaseName() {
        return mongoClient.listDatabaseNames().first(); // Get first available database dynamically
    }
}
