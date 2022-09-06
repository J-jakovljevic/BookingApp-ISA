package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.BoatOwnerAuthorization;
import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.CottageOwnerAuthorization;
import com.example.BookingApp.reservations.dto.ActionDTO;
import com.example.BookingApp.reservations.dto.CancellationCheckDTO;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/quickReservations")
public class QuickReservationsController {
    private final IQuickReservationService quickReservationService;



    @ClientAuthorization
    @GetMapping(value = "/getFutureReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getFutureReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.findFutureReservationsForClient(clientId);
    }

    @ClientAuthorization
    @GetMapping(value = "/getPreviousReservationsByClient", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getPreviousReservationsByClient(@RequestParam("clientId") Long clientId) throws ParseException {
        return quickReservationService.findPreviousReservationsForClient(clientId);
    }

    @BoatOwnerAuthorization
    @GetMapping(value = "/getFutureReservationsByBoatOwner", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getFutureReservationsByBoatOwner(@RequestParam("id") Long id) throws ParseException {
        return quickReservationService.findFutureReservationsForBoatOwner(id);
    }

    @BoatOwnerAuthorization
    @GetMapping(value = "/getPreviousReservationsByBoatOwner", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getPreviousReservationsByBoatOwner(@RequestParam("id") Long id) throws ParseException {
        return quickReservationService.findPreviousReservationsForBoatOwner(id);
    }

    @CottageOwnerAuthorization
    @GetMapping(value = "/getFutureReservationsByCottageOwner", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getFutureReservationsByCottageOwner(@RequestParam("id") Long id) throws ParseException {
        return quickReservationService.findFutureReservationsForCottageOwner(id);
    }

    @CottageOwnerAuthorization
    @GetMapping(value = "/getPreviousReservationsByCottageOwner", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getPreviousReservationsByCottageOwner(@RequestParam("id") Long id) throws ParseException {
        return quickReservationService.findPreviousReservationsForCottageOwner(id);
    }

    @ClientAuthorization
    @GetMapping(value = "/getById", produces =  MediaType.APPLICATION_JSON_VALUE)
    public QuickReservationDTO getById(@RequestParam("id") Long id) throws ParseException {
        return QuickReservationMapper.MapToDTO(quickReservationService.findById(id));
    }

    @BoatOwnerAuthorization
    @CottageOwnerAuthorization
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

    @ClientAuthorization
    @CottageOwnerAuthorization
    @GetMapping(value = "/getFutureQuickReservationsForCottage", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getFutureReservationsForCottage(@RequestParam("cottageId") Long cottageId) throws ParseException {
        return quickReservationService.findFutureQuickReservationsForCottage(cottageId);
    }

    @ClientAuthorization
    @BoatOwnerAuthorization
    @GetMapping(value = "/getFutureQuickReservationsForBoat",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<QuickReservationDTO> getFutureReservationsForBoat(@RequestParam("boatId") Long boatId) throws ParseException {
        return quickReservationService.findFutureQuickReservationsForBoat(boatId);
    }

    @ClientAuthorization
    @BoatOwnerAuthorization
    @PostMapping(value = "/checkPeriodQR/{cottageId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public Boolean checkPeriodQR(@PathVariable Long cottageId, @RequestBody ActionDTO action) throws ParseException {
        return quickReservationService.checkPeriodQR(cottageId, action);
    }

    @CottageOwnerAuthorization
    @GetMapping(value = "/calculateCottageProfitForQR/{cottageOwnerId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public double calculateCottageProfitForReservations(@PathVariable Long cottageOwnerId, @RequestParam("startDate") String startDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date=formatter.parse(startDate);
        return quickReservationService.calculateCottageProfitForQR(cottageOwnerId, date);
    }

    @BoatOwnerAuthorization
    @GetMapping(value = "/calculateBoatProfitForQR/{boatOwnerId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public double calculateBoatProfitForReservations(@PathVariable Long boatOwnerId, @RequestParam("startDate") String startDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date=formatter.parse(startDate);
        return quickReservationService.calculateBoatProfitForQR(boatOwnerId, date);
    }
}
