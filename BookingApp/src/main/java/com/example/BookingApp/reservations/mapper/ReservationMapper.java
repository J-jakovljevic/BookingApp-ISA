package com.example.BookingApp.reservations.mapper;

import com.example.BookingApp.renting.dto.AdditionalServiceDTO;
import com.example.BookingApp.renting.mapper.AdditionalServiceMapper;
import com.example.BookingApp.renting.mapper.RentingItemMapper;
import com.example.BookingApp.reservations.dto.RentingItemAvailabilityDTO;
import com.example.BookingApp.reservations.dto.ReservationDTO;
import com.example.BookingApp.reservations.model.RentingItemAvailability;
import com.example.BookingApp.reservations.model.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationMapper {
    public static Reservation MapDTOToReservation(ReservationDTO dto){
        Reservation r = new Reservation();
        r.setEndTime(dto.getEndTime());
        r.setStartTime(dto.getStartTime());
        r.setPrice(dto.getPrice());
        return r;
    }

    public static ReservationDTO MapToDTO(Reservation r){
        ReservationDTO dto= new ReservationDTO(r.getId(),r.getClient().getId(), RentingItemMapper.MapToDTO(r.getRentingItem()),r.getStartTime(),r.getEndTime(),
                r.getPrice(), AdditionalServiceMapper.MapToListDTO(r.getAdditionalServices()),r.getRentingItem().getId());
        return dto;
    }

    public static List<ReservationDTO> MapToListDTO(List<Reservation> reservations){
        List<ReservationDTO> dtos = new ArrayList<ReservationDTO>();
        for(Reservation r  : reservations){
            dtos.add(MapToDTO(r));
        }
        return dtos;
    }

    public static List<Reservation> MapDTOSToList(List<ReservationDTO> dtos){
        List<Reservation> reservations = new ArrayList<Reservation>();
        for(ReservationDTO dto : dtos){
            reservations.add(MapDTOToReservation(dto));
        }
        return reservations;
    }
}
