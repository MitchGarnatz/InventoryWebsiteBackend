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
@Document(collection = "Order")

public class Order {
    @Id
    private String confirmationNum;
    private String name;
    private String location;
    private Integer price;
    private String imagePath;
}