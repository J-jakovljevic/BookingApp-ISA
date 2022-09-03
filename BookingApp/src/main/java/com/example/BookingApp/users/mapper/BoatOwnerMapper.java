package com.example.BookingApp.users.mapper;

import com.example.BookingApp.users.dto.BoatOwnerDTO;
import com.example.BookingApp.users.dto.CottageOwnerDTO;
import com.example.BookingApp.users.model.BoatOwner;
import com.example.BookingApp.users.model.CottageOwner;

import java.util.ArrayList;
import java.util.List;

public class BoatOwnerMapper {
    public static BoatOwnerDTO MapToDTO(BoatOwner b){
        BoatOwnerDTO dto = new BoatOwnerDTO(b.getId(),b.getName(),b.getSurname(),
                b.getAddress(),b.getPassword(),b.getPhoneNumber(),b.getEmail(),b.getRole());
        return dto;
    }

    public static BoatOwner MapDTOToBoatOwner(BoatOwnerDTO dto){
        BoatOwner b = new BoatOwner();
        b.setId(dto.getId());
        b.setEmail(dto.getEmail());
        b.setName(dto.getName());
        b.setPassword(dto.getPassword());
        b.setPhoneNumber(dto.getPhoneNumber());
        b.setSurname(dto.getSurname());
        b.setRole(dto.getRole());
        b.setPassword(dto.getPassword());
        b.setAddress(dto.getAddress());
        return b;
    }

    public static List<BoatOwnerDTO> MapToListDTOS(List<BoatOwner> boatOwners) {
        List<BoatOwnerDTO> dtos = new ArrayList<>();
        for(BoatOwner b : boatOwners){
            dtos.add(MapToDTO(b));
        }
        return dtos;
    }
}
