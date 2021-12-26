package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.reservations.dto.PenaltyDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.mapper.ReservationMapper;
import com.example.BookingApp.reservations.model.Penalty;
import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.reservations.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationService reservationService;

    @ClientAuthorization
    @PostMapping(value = "/create", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ReservationDTO create(@RequestBody ReservationDTO dto) throws ParseException {
        Reservation reservation;
        try {
            reservation = reservationService.create(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return ReservationMapper.MapToDTO(reservation);
    }
}
