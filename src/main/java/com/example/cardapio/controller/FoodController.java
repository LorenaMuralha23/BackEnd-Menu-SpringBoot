package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //essa classe é um controller da nossa aplicação
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @GetMapping(value = "/allFood")
    public List<Food> getAll(){
        List<Food> foodList = repository.findAll();
        return foodList;
    }

}
