package com.example.BookingApp.renting.mapper;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.dto.RentingItemDTO;
import com.example.BookingApp.renting.model.Cottage;
import com.example.BookingApp.renting.model.RentingItem;
import com.example.BookingApp.reservations.service.IRevisionService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class RentingItemMapper {

    public static RentingItemDTO MapToDTO(RentingItem r){
        RentingItemDTO dto= new RentingItemDTO(r.getId(),r.getName(),r.getAddress(),r.getDescription(),r.getCapacity(),r.getType(),0);
        return dto;
    }


}
