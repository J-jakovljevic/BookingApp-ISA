package com.example.BookingApp.users.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.CottageOwnerAuthorization;
import com.example.BookingApp.users.dto.CottageOwnerDTO;
import com.example.BookingApp.users.service.ICottageOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.BookingApp.users.model.CottageOwner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/cottageOwners")
public class CottageOwnerController {
    private final ICottageOwnerService cottageOwnerService;
    @Autowired
    ApplicationEventPublisher eventPublisher;
    public CottageOwnerController(ICottageOwnerService cottageOwnerService) {this.cottageOwnerService = cottageOwnerService;}

    @PostMapping(value = "/register", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerCottageOwner(@RequestBody CottageOwnerDTO dto) throws ParseException {
        try {
            cottageOwnerService.registerCottageOwner(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getAll", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<CottageOwnerDTO> getAll() throws ParseException{
        return cottageOwnerService.getAll();
    }

    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public CottageOwnerDTO getById(@RequestParam ("id") long id) throws ParseException {
        return cottageOwnerService.findById(id);
    }
    @CottageOwnerAuthorization
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public CottageOwnerDTO updateCottageOwner(@RequestBody CottageOwnerDTO dto) throws ParseException {
        CottageOwnerDTO cottageOwnerDTO = new CottageOwnerDTO();
        try{
            cottageOwnerDTO = cottageOwnerService.updateCottageOwner(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cottageOwnerDTO;
    }
}
