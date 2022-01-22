package com.example.BookingApp.users.repository;

import com.example.BookingApp.renting.model.Subscription;
import com.example.BookingApp.users.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query(value = "SELECT c FROM Client c WHERE c.verificationCode = ?1")
    Client findByVerificationCode(String verificationCode);
}
