package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.model.QuickReservation;

import java.util.List;

public interface IQuickReservationService {
    boolean cancelReservation(Long reservationId);
    QuickReservation findById(Long reservationId);
    List<QuickReservation> findAll();
    QuickReservation createReservation(QuickReservationDTO dto);
    public List<QuickReservationDTO> findPreviousReservationsForClient(Long clientId);
    public List<QuickReservationDTO> findFutureReservationsForClient(Long clientId);
}
