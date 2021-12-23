package com.example.BookingApp.reservations.mapper;

import com.example.BookingApp.reservations.dto.PenaltyDTO;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.model.Penalty;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.users.mapper.ClientMapper;

import java.util.ArrayList;
import java.util.List;

public class PenaltyMapper {

    public static PenaltyDTO MapToDTO(Penalty p){
        PenaltyDTO dto= new PenaltyDTO(p.getId(),p.getQuickReservation().getId());
        return dto;
    }

    public static List<PenaltyDTO> MapToListDTO(List<Penalty> penalties){
        List<PenaltyDTO> dtos = new ArrayList<PenaltyDTO>();
        for(Penalty p  : penalties){
            dtos.add(MapToDTO(p));
        }
        return dtos;
    }

}
