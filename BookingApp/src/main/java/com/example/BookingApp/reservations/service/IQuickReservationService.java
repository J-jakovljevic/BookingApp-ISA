package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.CancellationCheckDTO;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.model.QuickReservation;

import java.util.List;

public interface IQuickReservationService {
    boolean cancelReservation(Long reservationId);
    QuickReservation findById(Long reservationId);
    List<QuickReservation> findAll();
    QuickReservation createReservation(QuickReservationDTO dto);
    List<QuickReservationDTO> findPreviousReservationsForClient(Long clientId);
    List<QuickReservationDTO> findFutureReservationsForClient(Long clientId);
    boolean cancelledReservationExists(Long actionId,Long clientId);
}
