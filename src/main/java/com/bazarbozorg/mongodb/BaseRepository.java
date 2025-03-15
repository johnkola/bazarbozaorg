package com.bazarbozorg.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T> extends MongoRepository<T, UUID> {
    // Base repository for all MongoDB entities using UUID as the primary key
}
