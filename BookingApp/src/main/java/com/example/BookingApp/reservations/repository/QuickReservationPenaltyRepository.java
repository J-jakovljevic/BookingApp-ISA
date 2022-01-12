package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.QuickReservationPenalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuickReservationPenaltyRepository extends JpaRepository<QuickReservationPenalty,Long> {
    @Query(value = "SELECT p FROM QuickReservationPenalty p WHERE p.quickReservation.client.id = ?1")
    List<QuickReservationPenalty> getAllByClient(Long clientId);
}
