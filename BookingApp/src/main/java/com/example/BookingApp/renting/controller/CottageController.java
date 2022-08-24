package com.example.BookingApp.renting.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.CottageOwnerAuthorization;
import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.dto.FishingInstructorClassDTO;
import com.example.BookingApp.renting.service.ICottageService;
import com.example.BookingApp.users.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
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
    @GetMapping(value = "/search", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<CottageDTO> search(@RequestParam("searchInput") String searchInput) {
        return cottageService.search(searchInput);
    }
    @ClientAuthorization
    @GetMapping(value = "/sortByNameAscending", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CottageDTO> sortByNameAscending() throws ParseException {
        return cottageService.sortByNameAscending();
    }

    @ClientAuthorization
    @GetMapping(value = "/sortByNameDescending", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CottageDTO> sortByNameDescending() throws ParseException {
        return cottageService.sortByNameDescending();
    }

    @ClientAuthorization
    @GetMapping(value = "/sortByLocationAscending", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CottageDTO> sortByLocationAscending() throws ParseException {
        return cottageService.sortByLocationAscending();
    }

    @ClientAuthorization
    @GetMapping(value = "/sortByLocationDescending", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CottageDTO> sortByLocationDescending() throws ParseException {
        return cottageService.sortByLocationDescending();
    }
    @ClientAuthorization
    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CottageDTO getById(@RequestParam("id") Long id) throws ParseException {
        return cottageService.getById(id);
    }
    @CottageOwnerAuthorization
    @GetMapping(value = "/myCottages", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CottageDTO> myCottages(@RequestParam("ownerId") Long ownerId) throws ParseException {
        return cottageService.getByCottageOwner(ownerId);
    }
    @CottageOwnerAuthorization
    @GetMapping(value = "/searchMyCottages", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<CottageDTO> search(@RequestParam("searchInput") String searchInput, @RequestParam("ownerId") Long ownerId) {
        return cottageService.searchMyCottages(searchInput, ownerId);
    }


    @CottageOwnerAuthorization
    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteCottage(@RequestParam Long id) {
        try {
            cottageService.delete(id);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
