package com.example.BookingApp.renting.repository;

import com.example.BookingApp.renting.model.Subscription;
import com.example.BookingApp.reservations.model.QuickReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    @Query(value = "SELECT s FROM Subscription s WHERE s.client.id = ?1")
    List<Subscription> findAllForClient(Long clientId);

}
