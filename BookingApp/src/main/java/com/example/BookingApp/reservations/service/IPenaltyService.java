package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.PenaltyDTO;
import com.example.BookingApp.reservations.model.Penalty;

import java.util.List;

public interface IPenaltyService {
    Penalty createPenalty(PenaltyDTO penaltyDTO);
    List<Penalty> getByClient(Long clientId);
}
