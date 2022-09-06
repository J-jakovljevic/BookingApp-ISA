package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.ActionDTO;
import com.example.BookingApp.reservations.dto.CancellationCheckDTO;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.model.QuickReservation;

import java.util.Date;
import java.util.List;

public interface IQuickReservationService {
    boolean cancelReservation(Long reservationId);
    QuickReservation findById(Long reservationId);
    List<QuickReservation> findAll();
    QuickReservation createReservation(QuickReservationDTO dto);
    List<QuickReservationDTO> findPreviousReservationsForClient(Long clientId);
    List<QuickReservationDTO> findFutureReservationsForClient(Long clientId);
    boolean cancelledReservationExists(Long actionId,Long clientId);
    int countNumberOfReservationsForClient(Long clientId);
    List<QuickReservationDTO> findPreviousReservationsForCottageOwner(Long id);
    List<QuickReservationDTO> findFutureReservationsForCottageOwner(Long id);
    List<QuickReservationDTO> findPreviousReservationsForBoatOwner(Long id);
    List<QuickReservationDTO> findFutureReservationsForBoatOwner(Long id);
    Boolean checkPeriodQR(Long cottageId, ActionDTO action);
    List<QuickReservationDTO> findFutureQuickReservationsForCottage(Long cottageId);
    List<QuickReservationDTO> findFutureQuickReservationsForBoat(Long boatId);
    double calculateCottageProfitForQR(Long cottageOwnerId, Date date);
    double calculateBoatProfitForQR(Long boatOwnerId, Date date);
    Boolean checkPeriodQRForReservation(Long cottageId, ReservationDTO reservation);
    Boolean checkPeriodQRForBoat(Long boatId, ActionDTO action);
    Boolean checkPeriodQRForReservationForBoat(Long boatId, ReservationDTO reservation);
}
