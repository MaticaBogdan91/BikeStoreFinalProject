package com.example.BikeStore.mapper;

import com.example.BikeStore.entity.Gloves;
import com.example.BikeStore.rest.GlovesDTO;
import org.springframework.stereotype.Component;

@Component
public class GlovesMapper {

    public Gloves fromDTOToEntity(GlovesDTO glovesDTO) {return new Gloves(glovesDTO.getMaterial(),glovesDTO.getName(),glovesDTO.getColor(),
            glovesDTO.getId());
    }


    public GlovesDTO fromEntityToDTO(Gloves gloves) {return new GlovesDTO(gloves.getMaterial(),gloves.getName(),gloves.getColor(),
            gloves.getId());
    }

}
