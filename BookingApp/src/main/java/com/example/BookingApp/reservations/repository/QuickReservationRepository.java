package com.example.BookingApp.reservations.repository;
import com.example.BookingApp.reservations.model.QuickReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface QuickReservationRepository extends JpaRepository<QuickReservation, Long> {
    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and CAST(q.action.startTime as date) < CAST(?2 as date)")
    List<QuickReservation> findPreviousReservationsForClient(Long clientId,Date date);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and CAST(q.action.startTime as date) > CAST(?2 as date)")
    List<QuickReservation> findFutureReservationsForClient(Long clientId,Date date);

}

