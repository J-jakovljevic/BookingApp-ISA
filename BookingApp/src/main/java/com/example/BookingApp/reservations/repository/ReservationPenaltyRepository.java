package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.QuickReservationPenalty;
import com.example.BookingApp.reservations.model.ReservationPenalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationPenaltyRepository extends JpaRepository<ReservationPenalty,Long> {
    @Query(value = "SELECT p FROM ReservationPenalty p WHERE p.reservation.client.id = ?1")
    List<ReservationPenalty> getAllByClient(Long clientId);
}
