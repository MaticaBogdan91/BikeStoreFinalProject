package com.example.BikeStore.entity;

import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class SportBike extends Bikes{

    private String power;



    public SportBike(String power, String name, Integer fabricationYear, Long id) {
    }
}
