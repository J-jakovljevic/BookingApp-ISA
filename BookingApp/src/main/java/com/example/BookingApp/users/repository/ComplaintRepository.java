package com.example.BookingApp.users.repository;

import com.example.BookingApp.users.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
}
