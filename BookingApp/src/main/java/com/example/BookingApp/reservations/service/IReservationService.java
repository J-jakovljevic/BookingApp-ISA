package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.model.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation create(ReservationDTO dto);
    List<Reservation> findAll();
}
