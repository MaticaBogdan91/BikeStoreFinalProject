package com.example.BikeStore.entity;

import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Helmet extends  BikeAccesories{

    private String brand;

    public Helmet(String brand, String name, String color) {
    }
}
