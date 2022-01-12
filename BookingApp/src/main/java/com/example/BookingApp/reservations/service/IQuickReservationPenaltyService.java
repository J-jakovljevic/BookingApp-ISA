package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.QuickReservationPenaltyDTO;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.model.QuickReservationPenalty;

import java.util.List;

public interface IQuickReservationPenaltyService {
    QuickReservationPenalty createPenalty(QuickReservationPenaltyDTO penaltyDTO);
    List<QuickReservationPenalty> getByClient(Long clientId);
}
