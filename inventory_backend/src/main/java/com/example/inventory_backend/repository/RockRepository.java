package com.example.inventory_backend.repository;

import com.example.inventory_backend.model.Rock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RockRepository extends MongoRepository<Rock, String> {
}
