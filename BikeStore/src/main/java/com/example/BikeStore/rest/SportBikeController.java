package com.example.BikeStore.rest;

import com.example.BikeStore.entity.SportBike;
import com.example.BikeStore.mapper.SportBikeMapper;
import com.example.BikeStore.repository.SportBikesRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SportBikeController {
    private static final Logger logger = LogManager.getLogger(SportBikeController.class);

    @Autowired
    SportBikesRepository sportBikesRepository;

    @Autowired
    SportBikeMapper sportBikeMapper;

    @GetMapping("/get-sportbike")
    public ResponseEntity<List<SportBikeDTO>> getSportBike() {
        logger.info("Getting all sportBikes");
        List<SportBikeDTO> sportBikeDTO = new ArrayList<>();
        sportBikesRepository.findAll().forEach(sportBike -> sportBikeDTO.add(sportBikeMapper.fromEntityToDTO(sportBike)));
        return new ResponseEntity<>(sportBikeDTO, HttpStatus.OK);
    }

    @GetMapping("/get-sportbike/{id}")
    public ResponseEntity<SportBikeDTO> getSportBikeById(@PathVariable Long id) {
        final Optional<SportBike> optionalSportBike = sportBikesRepository.findById(id);
        return optionalSportBike.map(sportBike -> new ResponseEntity<>(sportBikeMapper.fromEntityToDTO(sportBike), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/create-sportbike")
    public ResponseEntity<SportBike> createSportBike(@RequestBody SportBike sportBike) {
        try {
            return new ResponseEntity<>(sportBikesRepository.save(sportBike), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("DataIntegrityViolationException: sportbike {} already exists", sportBike.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-sportbike/{id}")
    public ResponseEntity<Void> deleteSportBike(@PathVariable Long id) {
        try {
            sportBikesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Id: {} dosen't exist", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-sportbike/{id}")
    public ResponseEntity<?> updateSportBike(@PathVariable Long id, @RequestBody SportBike sportBike) {
        if (sportBikesRepository.findById(id).isEmpty()) {
            logger.error("Id: {} dosen't exist", id);
            return new ResponseEntity<>("Big Errr", HttpStatus.BAD_REQUEST);
        }
        sportBikesRepository.update(sportBike.getName(), id);
        return ResponseEntity.ok().build();
    }
}

