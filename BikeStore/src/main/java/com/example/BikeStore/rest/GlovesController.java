package com.example.BikeStore.rest;
import com.example.BikeStore.entity.Gloves;
import com.example.BikeStore.mapper.GlovesMapper;
import com.example.BikeStore.repository.GlovesRepository;
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
public class GlovesController {
    private static final Logger logger = LogManager.getLogger(GlovesController.class);

    @Autowired
    GlovesRepository glovesRepository;

    @Autowired
    GlovesMapper glovesMapper;

    @GetMapping("/get-gloves")
    public ResponseEntity<List<GlovesDTO>> getGloves() {
        logger.info("Getting all gloves");
        List<GlovesDTO> glovesDTO = new ArrayList<>();
        glovesRepository.findAll().forEach(gloves -> glovesDTO.add(glovesMapper.fromEntityToDTO(gloves)));
        return new ResponseEntity<>(glovesDTO,HttpStatus.OK);
    }

    @GetMapping("/get-gloves/{id}")
    public ResponseEntity<GlovesDTO> getGlovesById(@PathVariable Long id){
        final Optional<Gloves> optionalGloves = glovesRepository.findById(id);
        return optionalGloves.map(gloves -> new ResponseEntity<>(glovesMapper.fromEntityToDTO(gloves), HttpStatus.OK))
                .orElseGet(() ->  new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    @PostMapping("/create-gloves")
    public ResponseEntity<Gloves> createGloves(@RequestBody Gloves gloves) {
        try {
            return new ResponseEntity<>(glovesRepository.save(gloves), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("DataIntegrityViolationException: gloves {} already exists", gloves.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-gloves/{id}")
    public ResponseEntity<Void> deleteGloves(@PathVariable Long id) {
        try {
            glovesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Id: {} dosen't exist", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update-gloves/{id}")
    public ResponseEntity<?> updateGloves(@PathVariable Long id, @RequestBody Gloves gloves) {
        if( glovesRepository.findById(id).isEmpty()) {
            logger.error("Id: {} dosen't exist", id);
            return  new ResponseEntity<>( "Big Errr",HttpStatus.BAD_REQUEST);
        }
        glovesRepository.update(gloves.getName(),id);
        return ResponseEntity.ok().build();
    }
}




