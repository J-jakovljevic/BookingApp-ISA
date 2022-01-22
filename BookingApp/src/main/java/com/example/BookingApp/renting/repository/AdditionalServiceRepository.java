package com.example.BookingApp.renting.repository;

import com.example.BookingApp.renting.model.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalServiceRepository extends JpaRepository<AdditionalService,Long> {
    @Query(value = "SELECT a FROM AdditionalService a WHERE a.rentingItem.id = ?1")
    List<AdditionalService> findAllForRentingItem(Long rentingItemId);
}
