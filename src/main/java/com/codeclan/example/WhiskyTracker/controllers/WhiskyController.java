package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/pirates")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name="distillery", required = false) String distillery,
            @RequestParam(name="year", required = false) Integer year,
            @RequestParam(name="age", required = false) Integer age
    ) {
        if (name != null){
            return new ResponseEntity<>(whiskyRepository.findByName(name), HttpStatus.OK);
        }

        if (age != null){
            return new ResponseEntity<>(whiskyRepository.findByAge(age), HttpStatus.OK);
        }

        List<Whisky> foundWhiskies = whiskyRepository.findAll();
        return new ResponseEntity<List<Whisky>>(foundWhiskies, HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id){
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

}
