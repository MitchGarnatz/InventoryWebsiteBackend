package com.example.inventory_backend.controller;

import com.example.inventory_backend.model.RockName;
import com.example.inventory_backend.repository.RockNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/rock-name")
public class RockNameController {

    @Autowired
    private RockNameRepository rockNameRepository;

    @PostMapping("/create")
    public RockName create(@RequestBody RockName rockName){
        return rockNameRepository.save(rockName);
    }

    @GetMapping("/all")
    public List<RockName> getAllRocks() {
        return rockNameRepository.findAll();
    }

    @GetMapping("/unique-names")
    public List<String> getAllUniqueNames() {
        Set<String> uniqueNames = new TreeSet<>();
        List<RockName> rockObjects = rockNameRepository.findAll();

        for (RockName rockObject : rockObjects) {
            uniqueNames.add(rockObject.getName());
        }

        return new ArrayList<>(uniqueNames);
    }

    @GetMapping("/{id}")
    public Optional<RockName> findById(@PathVariable String id) {
        return rockNameRepository.findById(id);
    }

    @PutMapping("/update")
    public RockName update(@RequestBody RockName rock){
        return rockNameRepository.save(rock);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        rockNameRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        rockNameRepository.deleteAll();
    }
}