package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.reservations.dto.PenaltyDTO;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.dto.RentingItemAvailabilityDTO;
import com.example.BookingApp.reservations.dto.SearchReservationQueryDTO;
import com.example.BookingApp.reservations.mapper.RentingItemAvailabilityMapper;
import com.example.BookingApp.reservations.model.Penalty;
import com.example.BookingApp.reservations.model.RentingItemAvailability;
import com.example.BookingApp.reservations.service.IRentingItemAvailaibilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rentingItemAvailabilities")
public class RentingItemAvailabilityController {
    private final IRentingItemAvailaibilityService rentingItemAvailaibilityService;

    @ClientAuthorization
    @PostMapping(value = "/create", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody RentingItemAvailabilityDTO dto) throws ParseException {
        RentingItemAvailability rentingItemAvailability;
        try {
            rentingItemAvailability = rentingItemAvailaibilityService.create(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(rentingItemAvailability ,HttpStatus.OK);
    }

    @ClientAuthorization
    @PostMapping(value = "/searchByParameters", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<RentingItemAvailabilityDTO> searchByParameters(@RequestBody SearchReservationQueryDTO dto) throws ParseException {
        return RentingItemAvailabilityMapper.MapToListDTO(rentingItemAvailaibilityService.search(dto));
    }
}
