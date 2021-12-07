package com.example.BookingApp.renting.repository;

import com.example.BookingApp.renting.model.Cottage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CottageRepository extends JpaRepository<Cottage,Long> {
}
