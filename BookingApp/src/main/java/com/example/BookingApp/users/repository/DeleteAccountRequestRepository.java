package com.example.BookingApp.users.repository;

import com.example.BookingApp.reservations.model.QuickReservationPenalty;
import com.example.BookingApp.users.model.DeleteAccountRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeleteAccountRequestRepository extends JpaRepository<DeleteAccountRequest,Long> {
    @Query(value = "SELECT p FROM DeleteAccountRequest p WHERE p.approved = false")
    List<DeleteAccountRequest> getAll();
}
