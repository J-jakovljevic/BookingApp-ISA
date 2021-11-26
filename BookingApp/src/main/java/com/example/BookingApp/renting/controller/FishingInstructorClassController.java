package com.example.BookingApp.renting.controller;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.dto.FishingInstructorClassDTO;
import com.example.BookingApp.renting.service.IFishingInstructorClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*",origins="*")
@RequestMapping(value = "/fishingInstructorClasses")
public class FishingInstructorClassController {
    private final IFishingInstructorClassService fishingInstructorClassService;

    @Autowired
    public FishingInstructorClassController(IFishingInstructorClassService FishingInstructorClassService) {
        this.fishingInstructorClassService = FishingInstructorClassService;
    }
    @PostMapping(value = "/add", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addFishingInstructorClass(@RequestBody FishingInstructorClassDTO dto) throws ParseException {
        try {
            fishingInstructorClassService.addFishingInstructorClass(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/getAll", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<FishingInstructorClassDTO> getAll() throws ParseException {
        return fishingInstructorClassService.getAll();
    }
}
