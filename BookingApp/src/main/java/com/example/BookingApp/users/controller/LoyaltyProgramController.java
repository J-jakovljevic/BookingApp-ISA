package com.example.BookingApp.users.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.SystemAdminAuthorization;
import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.dto.ComplaintDTO;
import com.example.BookingApp.users.dto.LoyaltyProgramDTO;
import com.example.BookingApp.users.dto.LoyaltyProgramStatusDTO;
import com.example.BookingApp.users.mapper.ClientMapper;
import com.example.BookingApp.users.mapper.LoyaltyProgramMapper;
import com.example.BookingApp.users.service.ILoyaltyProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/loyaltyProgram")
@RequiredArgsConstructor
public class LoyaltyProgramController {
    private final ILoyaltyProgramService loyaltyProgramService;

    @SystemAdminAuthorization
    @PostMapping(value = "/create", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody LoyaltyProgramDTO dto) throws ParseException {
        try {
            loyaltyProgramService.create(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @SystemAdminAuthorization
    @PostMapping(value = "/update", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody LoyaltyProgramDTO dto) throws ParseException {
        try {
            loyaltyProgramService.update(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ClientAuthorization
    @SystemAdminAuthorization
    @GetMapping(value = "/get", produces =  MediaType.APPLICATION_JSON_VALUE)
    public LoyaltyProgramDTO get() throws ParseException {
        return LoyaltyProgramMapper.MapToDTO(loyaltyProgramService.getLoyaltyProgram());
    }

    @ClientAuthorization
    @GetMapping(value = "/getLoyaltyProgramStatusByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public LoyaltyProgramStatusDTO getLoyaltyProgramStatusByClient(Long clientId) throws ParseException {
        return loyaltyProgramService.getLoyaltyProgramStatusByClient(clientId);
    }

}
