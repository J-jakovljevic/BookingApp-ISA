package com.example.BookingApp.users.controller;
import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.users.dto.FishingInstructorDTO;
import com.example.BookingApp.users.service.IFishingInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/fishingInstructors")
public class FishingInstructorController {
    private final IFishingInstructorService fishingInstructorService;

    @Autowired
    public FishingInstructorController(IFishingInstructorService fishingInstructorService) {
        this.fishingInstructorService = fishingInstructorService;
    }


    @PostMapping(value = "/register", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerFishingInstructor(@RequestBody FishingInstructorDTO dto) throws ParseException {
        try {
            fishingInstructorService.add(dto);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/getAll", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<FishingInstructorDTO> getAll() throws ParseException {
        return fishingInstructorService.getAll();
    }

    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public FishingInstructorDTO getById(@RequestParam("id") long id) throws ParseException {
        return fishingInstructorService.getById(id);
    }
    @GetMapping(value = "/search", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<FishingInstructorDTO> search(@RequestParam("searchInput") String searchInput) {
        return fishingInstructorService.search(searchInput);
    }
}
