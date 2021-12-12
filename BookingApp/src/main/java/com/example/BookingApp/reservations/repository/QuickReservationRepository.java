package com.example.BookingApp.reservations.repository;
import com.example.BookingApp.reservations.model.QuickReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface QuickReservationRepository extends JpaRepository<QuickReservation, Long> {
    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and q.action.rentingItem.type='Boat'")
    List<QuickReservation> findBoatReservationsForClient(Long clientId);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and q.action.rentingItem.type='FishingInstructorClass'")
    List<QuickReservation> findFishingInstructorClassReservationsForClient(Long clientId);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and q.action.rentingItem.type='Cottage'")
    List<QuickReservation> findCottageReservationsForClient(Long clientId);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and CAST(q.action.startTime as date) > CAST(?2 as date) and q.action.rentingItem.type = 'Boat'")
    List<QuickReservation> findFutureBoatReservationsForClient(Long clientId,Date date);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and CAST(q.action.startTime as date) > CAST(?2 as date) and q.action.rentingItem.type = 'Cottage'")
    List<QuickReservation> findFutureCottageReservationsForClient(Long clientId,Date date);

    @Query(value = "SELECT q FROM QuickReservation q WHERE q.client.id = ?1 and CAST(q.action.startTime as date) > CAST(?2 as date) and q.action.rentingItem.type = 'FishingInstructorClass'")
    List<QuickReservation> findFutureFishingInstructorClassReservationsForClient(Long clientId,Date date);


}

