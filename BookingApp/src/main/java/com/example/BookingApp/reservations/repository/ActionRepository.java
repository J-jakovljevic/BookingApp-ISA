package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    @Query(value = "SELECT a FROM Action a WHERE CAST(a.endTime as date) >= CAST(?1 as date) and a.reserved = false")
    List<Action> getCurrentActions(Date currentDate);

}
