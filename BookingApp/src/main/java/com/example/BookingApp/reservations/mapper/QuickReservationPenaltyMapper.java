package com.example.BookingApp.reservations.mapper;
import com.example.BookingApp.reservations.dto.QuickReservationPenaltyDTO;
import com.example.BookingApp.reservations.model.QuickReservationPenalty;

import java.util.ArrayList;
import java.util.List;

public class QuickReservationPenaltyMapper {

    public static QuickReservationPenaltyDTO MapToDTO(QuickReservationPenalty p){
        QuickReservationPenaltyDTO dto= new QuickReservationPenaltyDTO(p.getId(),p.getQuickReservation().getId());
        return dto;
    }

    public static List<QuickReservationPenaltyDTO> MapToListDTO(List<QuickReservationPenalty> penalties){
        List<QuickReservationPenaltyDTO> dtos = new ArrayList<QuickReservationPenaltyDTO>();
        for(QuickReservationPenalty p  : penalties){
            dtos.add(MapToDTO(p));
        }
        return dtos;
    }

}
