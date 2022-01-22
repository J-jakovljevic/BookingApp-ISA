package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.model.Reservation;
import com.example.BookingApp.reservations.model.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    @Query(value = "SELECT q FROM Reservation q WHERE q.client.id = ?1 and CAST(q.startTime as date) < CAST(?2 as date) and q.cancelled = false")
    List<Reservation> findPreviousReservationsForClient(Long clientId,Date date);

    @Query(value = "SELECT q FROM Reservation q WHERE q.client.id = ?1 and CAST(q.startTime as date) > CAST(?2 as date) and q.cancelled = false")
    List<Reservation> findFutureReservationsForClient(Long clientId,Date date);

    @Query(value = "SELECT q FROM Reservation q WHERE q.client.id = ?1 and q.rentingItem.id = ?2 " +
            "and CAST(q.startTime as date) = CAST(?3 as date) " +
            "and CAST(q.endTime as date) = CAST(?4 as date) " +
            "and q.cancelled = true")
    List<Reservation> cancelledReservationExists(Long clientId,Long rentingItemId,Date startDate,Date endDate);

    @Query(value = "SELECT q FROM Reservation q WHERE q.client.id = ?1 and q.cancelled = false")
    List<Reservation> findReservationsForClient(Long clientId);
}
