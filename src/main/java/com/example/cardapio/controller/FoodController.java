package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //essa classe é um controller da nossa aplicação
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    /*
        Um Record, nada mais é que um tipo de classe que armazena dados. É a mesma ideia de construção similar a um JavaBean, possui construtor, atributos e métodos acessores.
        Porém, ao invés de possibilitar qualquer alteração a classe é imutável.
        Também possui os métodos equals, hashCode e toString().
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/allFoods")
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
    }


}
