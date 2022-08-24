package com.example.BookingApp.reservations.service;

import com.example.BookingApp.reservations.dto.ReportDTO;
import com.example.BookingApp.reservations.model.Report;

import java.util.List;

public interface IReportService {
    Report create(ReportDTO dto);

    void approveReport(Long reportId);

    void deleteReport(Long reportId);

   List<Report> getAllUnapprovedReports();
}
