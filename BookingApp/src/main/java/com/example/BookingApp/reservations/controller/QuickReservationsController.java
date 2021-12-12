package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.mapper.QuickReservationMapper;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.service.IQuickReservationService;
import com.example.BookingApp.users.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/quickReservations")
public class QuickReservationsController {
    private final IQuickReservationService quickReservationService;

    @Autowired
    public QuickReservationsController(IQuickReservationService quickReservationService) {
        this.quickReservationService = quickReservationService;
    }

    @ClientAuthorization
    @GetMapping(value = "/getBoatReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getBoatReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.findBoatReservationsForClient(clientId);
    }

    @ClientAuthorization
    @GetMapping(value = "/getCottageReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getCottageReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.findCottageReservationsForClient(clientId);
    }

    @ClientAuthorization
    @GetMapping(value = "/getFishingInstructorClassReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getFishingInstructorClassReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.findFishingInstructorClassReservationsForClient(clientId);
    }

    @ClientAuthorization
    @GetMapping(value = "/getFutureBoatReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getFutureBoatReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.findFutureBoatReservations(clientId);
    }

    @ClientAuthorization
    @GetMapping(value = "/getFutureCottageReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getFutureCottageReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.findFutureCottageReservations(clientId);
    }

    @ClientAuthorization
    @GetMapping(value = "/getFutureFishingInstructorClassReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getFutureFishingInstructorClassReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.findFutureFishingInstructorClassReservations(clientId);
    }

    @ClientAuthorization
    @PostMapping(value = "/cancelReservation", produces =  MediaType.APPLICATION_JSON_VALUE)
    public boolean cancelReservation(@RequestParam("reservationId") Long reservationId) throws ParseException {
        return quickReservationService.cancelReservation(reservationId);
    }

}
