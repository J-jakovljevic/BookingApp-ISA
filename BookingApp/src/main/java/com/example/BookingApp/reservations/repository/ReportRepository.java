package com.example.BookingApp.reservations.repository;

import com.example.BookingApp.reservations.model.Report;
import com.example.BookingApp.reservations.model.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Long> {

    @Query(value = "SELECT r FROM Report r WHERE r.approved = false")
    List<Report> getAllUnapprovedReports();
}
