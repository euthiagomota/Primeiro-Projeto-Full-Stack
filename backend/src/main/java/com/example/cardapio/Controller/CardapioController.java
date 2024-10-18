package com.example.cardapio.Controller;

import com.example.cardapio.Food.CreateFoodDto;
import com.example.cardapio.Food.Food;
import com.example.cardapio.Food.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    FoodRepository foodRepository;

    @GetMapping
    public List<Food> findAll() {
        List<Food> foods = this.foodRepository.findAll();
        return foods;
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodDto createFoodDto) {
        Food food = new Food(createFoodDto.name(), createFoodDto.image(), createFoodDto.price());
        Food foodCreated = this.foodRepository.save(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(foodCreated);
    }
}
