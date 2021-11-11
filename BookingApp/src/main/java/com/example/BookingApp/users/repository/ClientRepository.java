package com.example.BookingApp.users.repository;

import com.example.BookingApp.users.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
