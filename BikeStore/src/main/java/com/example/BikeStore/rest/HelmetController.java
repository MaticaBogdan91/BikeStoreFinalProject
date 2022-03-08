package com.example.BikeStore.rest;

import com.example.BikeStore.entity.Helmet;
import com.example.BikeStore.mapper.HelmetMapper;
import com.example.BikeStore.repository.HelmetRepository;
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
public class HelmetController {

    private static final Logger logger = LogManager.getLogger(HelmetController.class);

    @Autowired
    HelmetRepository helmetRepository;

    @Autowired
    HelmetMapper helmetMapper;

    @GetMapping("/get-helmet")
    public ResponseEntity<List<HelmetDTO>> getHelmet() {
        logger.info("Getting all helmets");
        List<HelmetDTO> helmetDTO = new ArrayList<>();
        helmetRepository.findAll().forEach(helmet -> helmetDTO.add(helmetMapper.fromEntityToDTO(helmet)));
        return new ResponseEntity<>(helmetDTO,HttpStatus.OK);
    }

    @GetMapping("/get-helmet/{id}")
    public ResponseEntity<HelmetDTO> getHelmetById(@PathVariable Long id) {
        final Optional<Helmet> optionalHelmet = helmetRepository.findById(id);
        return optionalHelmet.map(helmet -> new ResponseEntity<>(helmetMapper.fromEntityToDTO(helmet), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/create-helmet")
    public ResponseEntity<Helmet> createHelmet(@RequestBody Helmet helmet) {
        try {
            return new ResponseEntity<>(helmetRepository.save(helmet), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("DataIntegrityViolationException: helmet {} already exists", helmet.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-helmet/{id}")
    public ResponseEntity<Void> deleteHelmet(@PathVariable Long id) {
        try {
            helmetRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Id: {} dosen't exist", id);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update-helmet/{id}")
    public ResponseEntity<?> updateHelmet(@PathVariable Long id, @RequestBody Helmet helmet) {
        if( helmetRepository.findById(id).isEmpty()) {
            logger.error("Id: {} dosen't exist", id);
            return  new ResponseEntity<>( "Big Errr",HttpStatus.BAD_REQUEST);
        }
        helmetRepository.update(helmet.getName(),id);
        return ResponseEntity.ok().build();
    }
}


