package com.example.cardapio.Food;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "foods")
@Entity(name = "foods")
public class Food {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;

@Column(nullable = false)
String name;

@Column(nullable = false)
String image;

@Column(nullable = false)
Integer price;

public Food(String name, String image, Integer price) {
    this.image = image;
    this.name = name;
    this.price = price;
}
}
