package com.example.BookingApp.users.repository;

import com.example.BookingApp.users.model.LoyaltyProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyProgramRepository  extends JpaRepository<LoyaltyProgram,Long> {
}
