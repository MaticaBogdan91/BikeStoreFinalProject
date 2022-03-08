package com.example.BikeStore.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SportBikeDTO {

    private String power;

    private  String name;

    private  Integer fabricationYear;

    private  Long id;
}
