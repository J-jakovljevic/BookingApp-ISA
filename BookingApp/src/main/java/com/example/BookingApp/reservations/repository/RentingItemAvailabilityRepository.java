package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.model.RentingItemAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RentingItemAvailabilityRepository extends JpaRepository<RentingItemAvailability,Long> {
    @Query(value = "SELECT r FROM RentingItemAvailability r WHERE CAST(r.startTime as date) <= CAST(?1 as date) " +
            "and CAST(r.endTime as date) >= CAST(?2 as date) " +
            "and r.rentingItem.type = ?4 and r.rentingItem.capacity >= ?3")
    List<RentingItemAvailability> searchByParameters(Date startTime,Date endTime,int capacity,String type);

}
