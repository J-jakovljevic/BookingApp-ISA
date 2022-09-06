package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.ActionDTO;
import com.example.BookingApp.reservations.dto.CancellationCheckDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.model.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    Reservation create(ReservationDTO dto);
    List<Reservation> findAll();
    boolean cancelReservation(Long reservationId);
    List<ReservationDTO> findPreviousReservationsForClient(Long clientId);
    List<ReservationDTO> findFutureReservationsForClient(Long clientId);
    Reservation findById(Long id);
    boolean cancelledReservationExists(CancellationCheckDTO dto);
    int countNumberOfReservationsForClient(Long clientId);
    List<ReservationDTO> findAllReservationsForCottage(Long cottageId);
    List<ReservationDTO> findFutureReservationsForCottageOwner(Long cottageOwnerId);
    List<ReservationDTO> findPreviousReservationsForCottageOwner(Long cottageOwnerId);
    List<ReservationDTO> findPreviousReservationsForBoatOwner(Long boatOwnerId);
    List<ReservationDTO> findFutureReservationsForBoatOwner(Long boatOwnerId);
    List<ReservationDTO> findFutureReservationsForCottage(Long cottageId);
    List<ReservationDTO> findFutureReservationsForBoat(Long boatId);
    Boolean checkPeriod(Long cottageId, ActionDTO action);
    double calculateCottageProfitForReservations(Long cottageOwnerId, Date startDate);
    double calculateBoatProfitForReservations(Long boatOwnerId, Date date);
}
