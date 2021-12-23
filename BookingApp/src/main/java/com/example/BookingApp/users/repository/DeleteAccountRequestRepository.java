package com.example.BookingApp.users.repository;

import com.example.BookingApp.users.model.DeleteAccountRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeleteAccountRequestRepository extends JpaRepository<DeleteAccountRequest,Long> {
}
