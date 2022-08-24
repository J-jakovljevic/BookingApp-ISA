package com.example.BookingApp.reservations.mapper;

import com.example.BookingApp.reservations.dto.ReportDTO;
import com.example.BookingApp.reservations.model.Report;

import java.util.ArrayList;
import java.util.List;

public class ReportMapper {
    public static ReportDTO MapToDTO(Report r) {
        ReportDTO dto = new ReportDTO(r.getId(),r.getClientId(), r.getReservationId(),r.getCottageOwnerId() ,r.getGrade(),r.getDescription());
        return dto;
    }

    public static Report MapDTOToReport(ReportDTO dto){
        Report r = new Report();
        r.setGrade(dto.getGrade());
        r.setDescription(dto.getDescription());
        return r;
    }


    public static List<ReportDTO> MapToListDTO(List<Report> Reports) {
        List<ReportDTO> dtos = new ArrayList<ReportDTO>();
        for(Report r: Reports){
            dtos.add(MapToDTO(r));
        }
        return dtos;
    }
}
