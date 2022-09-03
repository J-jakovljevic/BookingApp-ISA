package com.example.BookingApp.users.repository;

import com.example.BookingApp.users.model.BoatOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatOwnerRepository extends JpaRepository<BoatOwner, Long> {
}
