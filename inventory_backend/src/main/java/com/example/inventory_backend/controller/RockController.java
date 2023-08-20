package com.example.inventory_backend.controller;

import com.example.inventory_backend.model.Rock;
import com.example.inventory_backend.repository.RockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/rock")
public class RockController {

    @Autowired
    private RockRepository rockRepository;

    @PostMapping("/create")
    public Rock create(@RequestBody Rock rock){
        return rockRepository.save(rock);
    }

    @GetMapping("/all")
    public List<Rock> getAllRocks() {
        List<Rock> rockList = rockRepository.findAll();

        return rockList.stream()
                .sorted(Comparator.comparing(r -> r.getName().toLowerCase()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<Rock> findById(@PathVariable String id) {
        return rockRepository.findById(id);
    }

    @PutMapping("/update")
    public Rock update(@RequestBody Rock rock){
        return rockRepository.save(rock);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        rockRepository.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        rockRepository.deleteAll();
    }
}