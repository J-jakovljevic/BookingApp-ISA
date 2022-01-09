package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.model.QuickReservation;

import java.util.List;

public interface IQuickReservationService {
    List<QuickReservationDTO> findBoatReservationsForClient(Long clientId);
    List<QuickReservationDTO> findCottageReservationsForClient(Long clientId);
    List<QuickReservationDTO> findFishingInstructorClassReservationsForClient(Long clientId);
    List<QuickReservationDTO> findFutureBoatReservations(Long clientId);
    List<QuickReservationDTO> findFutureCottageReservations(Long clientId);
    List<QuickReservationDTO> findFutureFishingInstructorClassReservations(Long clientId);
    boolean cancelReservation(Long reservationId);
    QuickReservation findById(Long reservationId);
    List<QuickReservation> findAll();
}
