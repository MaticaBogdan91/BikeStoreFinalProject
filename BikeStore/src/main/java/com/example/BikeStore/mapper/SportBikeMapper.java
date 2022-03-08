package com.example.BikeStore.mapper;

import com.example.BikeStore.entity.SportBike;
import com.example.BikeStore.rest.SportBikeDTO;
import org.springframework.stereotype.Component;

@Component
public class SportBikeMapper {

    public SportBike fromDTOToEntity(SportBikeDTO sportBikeDTO) { return new SportBike(sportBikeDTO.getPower(),sportBikeDTO.getName(),
            sportBikeDTO.getFabricationYear(),sportBikeDTO.getId());}


    public SportBikeDTO fromEntityToDTO(SportBike sportBike) { return new SportBikeDTO(sportBike.getPower(),sportBike.getName(),
            sportBike.getFabricationYear(),sportBike.getId());}
}
