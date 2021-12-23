package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.renting.dto.SubscriptionDTO;
import com.example.BookingApp.renting.model.Subscription;
import com.example.BookingApp.reservations.dto.PenaltyDTO;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.mapper.PenaltyMapper;
import com.example.BookingApp.reservations.model.Penalty;
import com.example.BookingApp.reservations.service.IPenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/penalties")
@RequiredArgsConstructor
public class PenaltyController {
    private final IPenaltyService penaltyService;

    @ClientAuthorization
    @GetMapping(value = "/getByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<PenaltyDTO> getByClient(@RequestParam("clientId") Long clientId) {
        return PenaltyMapper.MapToListDTO(penaltyService.getByClient(clientId));
    }

    @ClientAuthorization
    @PostMapping(value = "/create", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPenalty(@RequestBody PenaltyDTO dto) throws ParseException {
        Penalty penalty;
        try {
            penalty = penaltyService.createPenalty(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(penalty,HttpStatus.OK);
    }
}
