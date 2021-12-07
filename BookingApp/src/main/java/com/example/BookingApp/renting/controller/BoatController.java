package com.example.BookingApp.renting.controller;

import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.mapper.BoatMapper;
import com.example.BookingApp.renting.service.IBoatService;
import com.example.BookingApp.renting.service.ICottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins="*")
@RequestMapping(value = "/boats")
public class BoatController {
    private final IBoatService boatService;

    @Autowired
    public BoatController(IBoatService boatService) {
        this.boatService = boatService;
    }

    @PostMapping(value = "/add", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addBoat(@RequestBody BoatDTO dto) throws ParseException {
        try {
            boatService.addBoat(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/getAll", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<BoatDTO> getAll() throws ParseException {
        return boatService.getAll();
    }

    @GetMapping(value = "/search", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<BoatDTO> search(@RequestParam("searchInput") String searchInput) {
        return boatService.search(searchInput);
    }
}
