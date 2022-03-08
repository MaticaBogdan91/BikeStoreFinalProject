package com.example.BikeStore.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity

public class BikeAccesories  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private  String name;

    private  String color;

    public  BikeAccesories(String name,String color){this.name = name; this.color = color;}

}
