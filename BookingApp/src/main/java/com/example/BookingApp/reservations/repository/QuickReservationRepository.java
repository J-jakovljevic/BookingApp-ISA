package com.example.BookingApp.reservations.repository;
import com.example.BookingApp.reservations.model.QuickReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface QuickReservationRepository extends JpaRepository<QuickReservation, Long> {
    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and CAST(q.action.startTime as date) < CAST(?2 as date) and q.cancelled = false")
    List<QuickReservation> findPreviousReservationsForClient(Long clientId,Date date);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and CAST(q.action.startTime as date) > CAST(?2 as date) and q.cancelled = false")
    List<QuickReservation> findFutureReservationsForClient(Long clientId,Date date);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?2 and q.action.id = ?1 " +
            "and q.cancelled = true")
    List<QuickReservation> cancelledReservationExists(Long actionId,Long clientId);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and q.cancelled = false")
    List<QuickReservation> findReservationsForClient(Long clientId);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.action.rentingItem.cottageOwner.id =?1 and CAST(q.action.startTime as date) < CAST(?2 as date) and q.cancelled = false")
    List<QuickReservation> findPreviousReservationsForCottageOwner(Long id, Date date);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.action.rentingItem.cottageOwner.id = ?1 and CAST(q.action.startTime as date) > CAST(?2 as date) and q.cancelled = false")
    List<QuickReservation> findFutureReservationsForCottageOwner(Long id, Date date);
}

