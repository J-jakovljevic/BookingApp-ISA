package com.example.BookingApp.renting.repository;

import com.example.BookingApp.renting.model.RentingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentingItemRepository extends JpaRepository<RentingItem,Long> {
}
