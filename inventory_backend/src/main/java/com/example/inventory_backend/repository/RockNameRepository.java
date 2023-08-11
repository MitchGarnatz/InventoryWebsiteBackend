package com.example.inventory_backend.repository;

import com.example.inventory_backend.model.RockName;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RockNameRepository extends MongoRepository<RockName, String> {
}
