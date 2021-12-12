package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
}
