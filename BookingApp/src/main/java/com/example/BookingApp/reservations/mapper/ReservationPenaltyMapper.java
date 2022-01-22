package com.example.BookingApp.reservations.mapper;


import com.example.BookingApp.reservations.dto.QuickReservationPenaltyDTO;
import com.example.BookingApp.reservations.dto.ReservationPenaltyDTO;
import com.example.BookingApp.reservations.model.QuickReservationPenalty;
import com.example.BookingApp.reservations.model.ReservationPenalty;

import java.util.ArrayList;
import java.util.List;

public class ReservationPenaltyMapper {
    public static ReservationPenaltyDTO MapToDTO(ReservationPenalty p){
        return new ReservationPenaltyDTO(p.getId(),p.getReservation().getId());
    }

    public static List<ReservationPenaltyDTO> MapToListDTO(List<ReservationPenalty> penalties){
        List<ReservationPenaltyDTO> dtos = new ArrayList<ReservationPenaltyDTO>();
        for(ReservationPenalty p  : penalties){
            dtos.add(MapToDTO(p));
        }
        return dtos;
    }
}
