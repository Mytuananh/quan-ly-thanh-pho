package com.example.quanlythanhpho.controller;

import com.example.quanlythanhpho.model.City;
import com.example.quanlythanhpho.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<Iterable<City>> findAll() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id) {
        Optional<City> categoryOptional = cityService.findById(id);
       if (!categoryOptional.isPresent()) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> addNewCity(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) {
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
