package com.example.inventory_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "Rock")
public class Rock {
    @Id
    private String id;
    private String name;
    private String location;
    private Integer weight;
    private Integer price;
    private Integer width;
    private Integer length;
    private Integer height;
    private String imagePath;
}