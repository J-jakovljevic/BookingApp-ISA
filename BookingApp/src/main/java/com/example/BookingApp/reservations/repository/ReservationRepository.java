package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.reservations.model.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
