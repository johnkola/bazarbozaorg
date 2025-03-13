package com.bazarbozorg.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T> extends MongoRepository<T, UUID> {
    // This acts as a base repository for all entities with UUID as primary key
}
