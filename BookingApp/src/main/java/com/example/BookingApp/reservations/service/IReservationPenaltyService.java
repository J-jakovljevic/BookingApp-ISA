package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.QuickReservationPenaltyDTO;
import com.example.BookingApp.reservations.dto.ReservationPenaltyDTO;
import com.example.BookingApp.reservations.model.QuickReservationPenalty;
import com.example.BookingApp.reservations.model.ReservationPenalty;

import java.util.List;

public interface IReservationPenaltyService {
    ReservationPenalty createPenalty(ReservationPenaltyDTO penaltyDTO);
    List<ReservationPenalty> getByClient(Long clientId);
}
