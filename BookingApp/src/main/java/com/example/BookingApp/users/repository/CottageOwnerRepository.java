package com.example.BookingApp.users.repository;

import com.example.BookingApp.users.model.CottageOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Long> {
}
