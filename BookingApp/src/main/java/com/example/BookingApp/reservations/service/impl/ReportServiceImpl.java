package com.example.BookingApp.reservations.service.impl;

import com.example.BookingApp.reservations.dto.ReportDTO;
import com.example.BookingApp.reservations.mapper.ReportMapper;
import com.example.BookingApp.reservations.model.Report;
import com.example.BookingApp.reservations.repository.ReportRepository;
import com.example.BookingApp.reservations.service.IReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements IReportService {

    private final ReportRepository reportRepository;

    @Override
    public Report create(ReportDTO dto) {
        Report r = ReportMapper.MapDTOToReport(dto);
        r.setApproved(false);
        return reportRepository.save(r);
    }

    @Override
    public void approveReport(Long reportId) {
        Report r = reportRepository.getById(reportId);
        r.setApproved(true);
        reportRepository.save(r);
    }

    @Override
    public void deleteReport(Long reportId) {
        reportRepository.delete(reportRepository.getById(reportId));
    }

    @Override
    public List<Report> getAllUnapprovedReports() {
        return reportRepository.getAllUnapprovedReports();
    }
}
