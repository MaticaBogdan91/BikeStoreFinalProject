package com.example.BikeStore.mapper;

import com.example.BikeStore.entity.Helmet;
import com.example.BikeStore.rest.HelmetDTO;
import org.springframework.stereotype.Component;

@Component
public class HelmetMapper {

    public Helmet fromDTOToEntity(HelmetDTO helmetDTO) { return new Helmet(helmetDTO.getBrand(),helmetDTO.getName(),helmetDTO.getColor());}


    public HelmetDTO fromEntityToDTO(Helmet helmet) { return new HelmetDTO(helmet.getBrand(),helmet.getName(),helmet.getColor());}

}
