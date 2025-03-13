package com.bazarbozorg.service;

import com.bazarbozorg.mongodb.repository.BaseRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<T> {

    protected BaseRepository<T> repository;
    protected MongoClient mongoClient; // ✅ Injected MongoClient for raw queries

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

    // ✅ Example of Raw MongoDB Query (if needed)
    public MongoCollection<T> getMongoCollection(String collectionName, Class<T> clazz) {
        MongoDatabase database = mongoClient.getDatabase("yourDatabase"); // ✅ Use the correct DB name
        return database.getCollection(collectionName, clazz);
    }
}
