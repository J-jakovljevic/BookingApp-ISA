package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.BoatOwnerAuthorization;
import com.example.BookingApp.autorizationAnnotations.ClientAuthorization;
import com.example.BookingApp.autorizationAnnotations.CottageOwnerAuthorization;
import com.example.BookingApp.reservations.dto.ActionDTO;
import com.example.BookingApp.reservations.dto.CancellationCheckDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.mapper.ReservationMapper;

import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.reservations.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

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

    @BoatOwnerAuthorization
    @CottageOwnerAuthorization
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

    @CottageOwnerAuthorization
    @GetMapping(value = "/getPreviousReservationsByCottageOwner", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDTO> getPreviousReservationsByCottageOwner(@RequestParam("cottageOwnerId") Long cottageOwnerId) throws ParseException {
        return reservationService.findPreviousReservationsForCottageOwner(cottageOwnerId);
    }

    @CottageOwnerAuthorization
    @GetMapping(value = "/getFutureReservationsByCottageOwner", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDTO> getFutureReservationsByCottageOwner(@RequestParam("cottageOwnerId") Long cottageOwnerId) throws ParseException {
        return reservationService.findFutureReservationsForCottageOwner(cottageOwnerId);
    }

    @BoatOwnerAuthorization
    @GetMapping(value = "/getPreviousReservationsByBoatOwner", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDTO> getPreviousReservationsByBoatOwner(@RequestParam("boatOwnerId") Long boatOwnerId) throws ParseException {
        return reservationService.findPreviousReservationsForBoatOwner(boatOwnerId);
    }

    @BoatOwnerAuthorization
    @GetMapping(value = "/getFutureReservationsByBoatOwner", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDTO> getFutureReservationsByBoatOwner(@RequestParam("boatOwnerId") Long boatOwnerId) throws ParseException {
        return reservationService.findFutureReservationsForBoatOwner(boatOwnerId);
    }

    @ClientAuthorization
    @CottageOwnerAuthorization
    @GetMapping(value = "/getFutureReservationsForCottage", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDTO> getFutureReservationsForCottage(@RequestParam("cottageId") Long cottageId) throws ParseException {
        return reservationService.findFutureReservationsForCottage(cottageId);
    }

    @ClientAuthorization
    @BoatOwnerAuthorization
    @GetMapping(value = "/getFutureReservationsForBoat",  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReservationDTO> getFutureReservationsForBoat(@RequestParam("boatId") Long boatId) throws ParseException {
        return reservationService.findFutureReservationsForBoat(boatId);
    }

    @ClientAuthorization
    @CottageOwnerAuthorization
    @PostMapping(value = "/checkPeriod/{cottageId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public Boolean checkPeriod(@PathVariable Long cottageId, @RequestBody ActionDTO action) throws ParseException {
        return reservationService.checkPeriod(cottageId, action);
    }

    @ClientAuthorization
    @BoatOwnerAuthorization
    @PostMapping(value = "/checkPeriod/{boatId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public Boolean checkPeriodForBoat(@PathVariable Long boatId, @RequestBody ActionDTO action) throws ParseException {
        return reservationService.checkPeriodForBoat(boatId, action);
    }

    @ClientAuthorization
    @CottageOwnerAuthorization
    @PostMapping(value = "/checkPeriodForReservation/{cottageId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public Boolean checkPeriodForReservation(@PathVariable Long cottageId, @RequestBody ReservationDTO reservation) throws ParseException {
        return reservationService.checkPeriodForReservation(cottageId, reservation);
    }

    @ClientAuthorization
    @BoatOwnerAuthorization
    @PostMapping(value = "/checkPeriodForReservationForBoat/{boatId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public Boolean checkPeriodForReservationForBoat(@PathVariable Long boatId, @RequestBody ReservationDTO reservation) throws ParseException {
        return reservationService.checkPeriodForReservationForBoat(boatId, reservation);
    }

    @CottageOwnerAuthorization
    @GetMapping(value = "/calculateCottageProfitForReservations/{cottageOwnerId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public double calculateCottageProfitForReservations(@PathVariable Long cottageOwnerId, @RequestParam("startDate") String startDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date=formatter.parse(startDate);
        return reservationService.calculateCottageProfitForReservations(cottageOwnerId, date);
    }

    @BoatOwnerAuthorization
    @GetMapping(value = "/calculateBoatProfitForReservations/{boatOwnerId}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public double calculateBoatProfitForReservations(@PathVariable Long boatOwnerId, @RequestParam("startDate") String startDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date=formatter.parse(startDate);
        return reservationService.calculateBoatProfitForReservations(boatOwnerId, date);
    }
}
