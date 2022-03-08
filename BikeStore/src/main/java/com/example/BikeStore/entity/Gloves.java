package com.example.BikeStore.entity;

import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Gloves extends  BikeAccesories{

    protected String material;

    public Gloves(String material, String name, String color, Long id) {
        
    }
}
