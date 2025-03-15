package com.bazarbozorg.web.controller.controller;

import com.bazarbozorg.mongodb.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseController<T> {

    protected final BaseService<T> service;

    public BaseController(BaseService<T> service) {
        this.service = service;
    }

    // ✅ Get all entities
    @GetMapping
    public ResponseEntity<List<T>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // ✅ Get entity by ID
    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable UUID id) {
        Optional<T> entity = service.getById(id);
        return entity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Create or update entity
    @PostMapping
    public ResponseEntity<T> createOrUpdate(@RequestBody T entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    // ✅ Delete entity by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
