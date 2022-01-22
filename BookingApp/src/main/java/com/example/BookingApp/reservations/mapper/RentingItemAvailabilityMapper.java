package com.example.BookingApp.reservations.mapper;

import com.example.BookingApp.reservations.dto.QuickReservationDTO;
import com.example.BookingApp.reservations.dto.RentingItemAvailabilityDTO;
import com.example.BookingApp.reservations.model.QuickReservation;
import com.example.BookingApp.reservations.model.RentingItemAvailability;
import com.example.BookingApp.users.mapper.ClientMapper;

import java.util.ArrayList;
import java.util.List;

public class RentingItemAvailabilityMapper {
    public static RentingItemAvailability MapDTOToRentingItemAvailability(RentingItemAvailabilityDTO dto){
        RentingItemAvailability r = new RentingItemAvailability();
        r.setEndTime(dto.getEndTime());
        r.setStartTime(dto.getStartTime());
        r.setPrice(dto.getPrice());
        return r;
    }

    public static RentingItemAvailabilityDTO MapToDTO(RentingItemAvailability q){
        RentingItemAvailabilityDTO dto= new RentingItemAvailabilityDTO(q.getId(),q.getRentingItem().getId(),q.getStartTime(),q.getEndTime(),q.getPrice());
        return dto;
    }

    public static List<RentingItemAvailabilityDTO> MapToListDTO(List<RentingItemAvailability> rentingItemAvailabilities){
        List<RentingItemAvailabilityDTO> dtos = new ArrayList<RentingItemAvailabilityDTO>();
        for(RentingItemAvailability r  : rentingItemAvailabilities){
            dtos.add(MapToDTO(r));
        }
        return dtos;
    }

    public static List<RentingItemAvailability> MapDTOSToList(List<RentingItemAvailabilityDTO> dtos){
        List<RentingItemAvailability> rentingItemAvailabilities = new ArrayList<RentingItemAvailability>();
        for(RentingItemAvailabilityDTO dto : dtos){
            rentingItemAvailabilities.add(MapDTOToRentingItemAvailability(dto));
        }
        return rentingItemAvailabilities;
    }
}
