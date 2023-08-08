package com.example.inventory_backend.controller;

import com.example.inventory_backend.model.Inventory;
import com.example.inventory_backend.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping("/create")
    public Inventory create(@RequestBody Inventory record){
        return inventoryRepository.save(record);
    }

    @GetMapping("/all")
    public List<Inventory> getAllRecords() {
        return inventoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Inventory> findById(@PathVariable String id) {
        return inventoryRepository.findById(id);
    }

    @PutMapping("/update")
    public Inventory update(@RequestBody Inventory record){
        return inventoryRepository.save(record);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        inventoryRepository.deleteById(id);
    }
}