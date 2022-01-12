package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.reservations.dto.QuickReservationPenaltyDTO;
import com.example.BookingApp.reservations.mapper.QuickReservationPenaltyMapper;
import com.example.BookingApp.reservations.model.QuickReservationPenalty;
import com.example.BookingApp.reservations.service.IQuickReservationPenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/quickReservationPenalties")
@RequiredArgsConstructor
public class QuickReservationPenaltyController {
    private final IQuickReservationPenaltyService penaltyService;

    @ClientAuthorization
    @GetMapping(value = "/getByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationPenaltyDTO> getByClient(@RequestParam("clientId") Long clientId) {
        return QuickReservationPenaltyMapper.MapToListDTO(penaltyService.getByClient(clientId));
    }

    @ClientAuthorization
    @PostMapping(value = "/create", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPenalty(@RequestBody QuickReservationPenaltyDTO dto) throws ParseException {
        QuickReservationPenalty penalty;
        try {
            penalty = penaltyService.createPenalty(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(penalty,HttpStatus.OK);
    }
}
