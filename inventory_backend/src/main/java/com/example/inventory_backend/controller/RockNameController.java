package com.example.inventory_backend.controller;

import com.example.inventory_backend.model.RockName;
import com.example.inventory_backend.repository.RockNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/all-names")
    public List<String> getAllUniqueNames() {
        ArrayList<String> result = new ArrayList<>();
        List<RockName> rockObjects;

        rockObjects = rockNameRepository.findAll();

        for (RockName rockObject : rockObjects) {
            result.add(rockObject.getName());
        }

        return result;
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
}