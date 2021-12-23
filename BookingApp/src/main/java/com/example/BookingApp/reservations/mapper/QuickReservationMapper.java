package com.example.BookingApp.reservations.mapper;

import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.model.Boat;
import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.users.mapper.ClientMapper;

import java.util.ArrayList;
import java.util.List;

public class QuickReservationMapper {

    public static QuickReservation MapDTOToQuickReservation(QuickReservationDTO dto){
        QuickReservation q = new QuickReservation();
        q.setAction(ActionMapper.MapDTOToAction(dto.getAction()));
        q.setClient(ClientMapper.MapDTOToClient(dto.getClient()));
        return q;
    }

    public static QuickReservationDTO MapToDTO(QuickReservation q){
        QuickReservationDTO dto= new QuickReservationDTO(q.getId(),ClientMapper.MapToDTO(q.getClient()),ActionMapper.MapToDTO(q.getAction()));
        return dto;
    }

    public static List<QuickReservationDTO> MapToListDTO(List<QuickReservation> quickReservations){
        List<QuickReservationDTO> dtos = new ArrayList<QuickReservationDTO>();
        for(QuickReservation q  : quickReservations){
            dtos.add(MapToDTO(q));
        }
        return dtos;
    }

    public static List<QuickReservation> MapDTOSToList(List<QuickReservationDTO> dtos){
        List<QuickReservation> quickReservations = new ArrayList<QuickReservation>();
        for(QuickReservationDTO dto : dtos){
            quickReservations.add(MapDTOToQuickReservation(dto));
        }
        return quickReservations;
    }
}
