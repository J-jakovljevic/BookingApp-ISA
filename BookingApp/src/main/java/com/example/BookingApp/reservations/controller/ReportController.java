package com.example.BookingApp.reservations.controller;

import com.example.BookingApp.autorizationAnnotations.CottageOwnerAuthorization;
import com.example.BookingApp.autorizationAnnotations.SystemAdminAuthorization;
import com.example.BookingApp.reservations.dto.ReportDTO;
import com.example.BookingApp.reservations.mapper.ReportMapper;
import com.example.BookingApp.reservations.model.Report;
import com.example.BookingApp.reservations.service.IReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/reports")
@RequiredArgsConstructor
public class ReportController {
    @Autowired
    private final IReportService reportService;

    @CottageOwnerAuthorization
    @PostMapping(value = "/create", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ReportDTO create(@RequestBody ReportDTO dto) throws ParseException{
        Report report;
        try {
            report = reportService.create(dto);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

        return ReportMapper.MapToDTO(report);
    }

    @SystemAdminAuthorization
    @PostMapping(value = "/approveReport", consumes =MediaType.APPLICATION_JSON_VALUE)
    public boolean approveReport(@RequestBody Long reportId) throws ParseException {
        try {
            reportService.approveReport(reportId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @SystemAdminAuthorization
    @PostMapping(value = "/denyReport", consumes =MediaType.APPLICATION_JSON_VALUE)
    public boolean denyReport(@RequestBody Long reportId) throws ParseException {
        try {
            reportService.deleteReport(reportId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @SystemAdminAuthorization
    @GetMapping(value = "/getAllUnapprovedReports", produces =  MediaType.APPLICATION_JSON_VALUE)
    public List<ReportDTO> getAllUnapprovedReports() throws ParseException {
        return ReportMapper.MapToListDTO(reportService.getAllUnapprovedReports());
    }
}
