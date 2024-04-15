package com.example.cardapio.food;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "tb_food")
@Getter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Double price;

}
