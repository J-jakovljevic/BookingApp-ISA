package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.reservations.dto.CancellationCheckDTO;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.mapper.QuickReservationMapper;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.service.IQuickReservationService;
import com.example.BookingApp.users.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/quickReservations")
public class QuickReservationsController {
    private final IQuickReservationService quickReservationService;



    @ClientAuthorization
    @GetMapping(value = "/getPreviousReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getPreviousReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.findPreviousReservationsForClient(clientId);
    }

    @ClientAuthorization
    @GetMapping(value = "/getFutureReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getFutureReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.findFutureReservationsForClient(clientId);
    }

    @ClientAuthorization
    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public QuickReservationDTO getById(@RequestParam("id") Long id) throws ParseException {
        return QuickReservationMapper.MapToDTO(quickReservationService.findById(id));
    }



    @ClientAuthorization
    @PostMapping(value = "/cancelReservation", produces =  MediaType.APPLICATION_JSON_VALUE)
    public boolean cancelReservation(@RequestParam("reservationId") Long reservationId) throws ParseException {
        return quickReservationService.cancelReservation(reservationId);
    }

    @ClientAuthorization
    @PostMapping(value = "/create", produces =  MediaType.APPLICATION_JSON_VALUE)
    public QuickReservationDTO createReservation(@RequestBody QuickReservationDTO dto) throws ParseException {
        return QuickReservationMapper.MapToDTO(quickReservationService.createReservation(dto));
    }

    @ClientAuthorization
    @GetMapping(value = "/cancelledReservationExists", produces =  MediaType.APPLICATION_JSON_VALUE)
    public boolean cancelledReservationExists(@RequestParam("actionId") Long actionId,@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.cancelledReservationExists(actionId,clientId);
    }

}
