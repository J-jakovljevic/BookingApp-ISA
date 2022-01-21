package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.CancellationCheckDTO;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.model.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation create(ReservationDTO dto);
    List<Reservation> findAll();
    boolean cancelReservation(Long reservationId);
    List<ReservationDTO> findPreviousReservationsForClient(Long clientId);
    List<ReservationDTO> findFutureReservationsForClient(Long clientId);
    Reservation findById(Long id);
    boolean cancelledReservationExists(CancellationCheckDTO dto);
}
