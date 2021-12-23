package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.Penalty;
import com.example.BookingApp.reservations.model.QuickReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PenaltyRepository extends JpaRepository<Penalty,Long> {
    @Query(value = "SELECT p FROM Penalty p WHERE p.quickReservation.client.id = ?1")
    List<Penalty> getAllByClient(Long clientId);
}
