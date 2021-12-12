package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Long> {
}
