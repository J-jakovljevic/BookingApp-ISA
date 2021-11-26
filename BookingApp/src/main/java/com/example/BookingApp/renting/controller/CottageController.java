package com.example.BookingApp.renting.controller;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.service.ICottageService;
import com.example.BookingApp.users.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin(allowedHeaders = "*",origins="*")
@RequestMapping(value = "/cottages")
public class CottageController {
    private final ICottageService cottageService;

    @Autowired
    public CottageController(ICottageService cottageService) {
        this.cottageService = cottageService;
    }

    @PostMapping(value = "/add", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCottage(@RequestBody CottageDTO dto) throws ParseException {
        try {
            cottageService.addCottage(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/getAll", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws ParseException {
        return new ResponseEntity<>(cottageService.getAll(),HttpStatus.OK);
    }
}
