package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.CottageOwnerAuthorization;
import com.example.BookingApp.reservations.dto.CancellationCheckDTO;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.mapper.QuickReservationMapper;
import com.example.BookingApp.reservations.mapper.ReservationMapper;

import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.reservations.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

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

    @CottageOwnerAuthorization
    @ClientAuthorization
    @GetMapping(value = "/getPreviousReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDTO> getPreviousReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return reservationService.findPreviousReservationsForClient(clientId);
    }

    @ClientAuthorization
    @GetMapping(value = "/getFutureReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDTO> getFutureReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return reservationService.findFutureReservationsForClient(clientId);
    }

    @ClientAuthorization
    @PostMapping(value = "/cancelReservation", produces =  MediaType.APPLICATION_JSON_VALUE)
    public boolean cancelReservation(@RequestParam("reservationId") Long reservationId) throws ParseException {
        return reservationService.cancelReservation(reservationId);
    }

    @ClientAuthorization
    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ReservationDTO getById(@RequestParam("id") Long id) throws ParseException {
        return ReservationMapper.MapToDTO(reservationService.findById(id));
    }

    @ClientAuthorization
    @PostMapping(value = "/cancelledReservationExists", produces =  MediaType.APPLICATION_JSON_VALUE)
    public boolean cancelledReservationExists(@RequestBody CancellationCheckDTO dto) throws ParseException {
        return reservationService.cancelledReservationExists(dto);
    }

    @CottageOwnerAuthorization
    @GetMapping(value = "/getAllReservationsByCottage", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDTO> getAllReservationsByCottage(@RequestParam("cottageId") Long cottageId) throws ParseException {
        return reservationService.findAllReservationsForCottage(cottageId);
    }
}
