package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.model.Reservation;

public interface IReservationService {
    Reservation create(ReservationDTO dto);
}
