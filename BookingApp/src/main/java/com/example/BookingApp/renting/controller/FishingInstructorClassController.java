package com.example.BookingApp.renting.controller;
import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.renting.dto.BoatDTO;
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

    @GetMapping(value = "/search", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<FishingInstructorClassDTO> search(@RequestParam("searchInput") String searchInput) throws ParseException {
        return fishingInstructorClassService.search(searchInput);
    }

    @ClientAuthorization
    @GetMapping(value = "/sortByNameAscending", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FishingInstructorClassDTO> sortByNameAscending() throws ParseException {
        return fishingInstructorClassService.sortByNameAscending();
    }

    @ClientAuthorization
    @GetMapping(value = "/sortByNameDescending", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FishingInstructorClassDTO> sortByNameDescending() throws ParseException {
        return fishingInstructorClassService.sortByNameDescending();
    }

    @ClientAuthorization
    @GetMapping(value = "/sortByLocationAscending", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FishingInstructorClassDTO> sortByLocationAscending() throws ParseException {
        return fishingInstructorClassService.sortByLocationAscending();
    }

    @ClientAuthorization
    @GetMapping(value = "/sortByLocationDescending", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FishingInstructorClassDTO> sortByLocationDescending() throws ParseException {
        return fishingInstructorClassService.sortByLocationDescending();
    }
    @ClientAuthorization
    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody FishingInstructorClassDTO getById(@RequestParam("id") Long id) throws ParseException {
        return fishingInstructorClassService.getById(id);
    }
}
