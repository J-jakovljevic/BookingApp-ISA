package com.example.BookingApp.renting.repository;

import com.example.BookingApp.renting.model.AdditionalService;
import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.renting.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentingItemRepository extends JpaRepository<RentingItem,Long> {

}
