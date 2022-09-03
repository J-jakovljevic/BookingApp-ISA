package com.example.BookingApp.users.controller;

import com.example.BookingApp.autorizationAnnotations.BoatOwnerAuthorization;
import com.example.BookingApp.users.dto.BoatOwnerDTO;
import com.example.BookingApp.users.dto.CottageOwnerDTO;
import com.example.BookingApp.users.service.IBoatOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/boatOwners")
public class BoatOwnerController {
    private final IBoatOwnerService boatOwnerService;
    @Autowired
    ApplicationEventPublisher eventPublisher;
    public BoatOwnerController(IBoatOwnerService boatOwnerService) {
        this.boatOwnerService = boatOwnerService;
    }

    @PostMapping(value = "/register", consumes =  MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<?> registerBoatOwner(@RequestBody BoatOwnerDTO dto) throws ParseException {
        try {
            boatOwnerService.add(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getAll", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<BoatOwnerDTO> getAll() throws ParseException{
        return boatOwnerService.getAll();
    }

    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public BoatOwnerDTO getById(@RequestParam ("id") long id) throws ParseException {
        return boatOwnerService.findById(id);
    }

    @BoatOwnerAuthorization
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public BoatOwnerDTO updateBoatOwner(@RequestBody BoatOwnerDTO dto) throws ParseException {
        BoatOwnerDTO boatOwnerDTO = new BoatOwnerDTO();
        try{
            boatOwnerDTO = boatOwnerService.updateBoatOwner(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boatOwnerDTO;
    }
}

