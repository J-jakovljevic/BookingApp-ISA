package com.example.BookingApp.users.mapper;

import com.example.BookingApp.users.dto.CottageOwnerDTO;
import com.example.BookingApp.users.model.CottageOwner;

import java.util.ArrayList;
import java.util.List;

public class CottageOwnerMapper
{
    public static CottageOwnerDTO MapToDTO(CottageOwner c){
        CottageOwnerDTO dto = new CottageOwnerDTO(c.getId(),c.getName(),c.getSurname(),
                c.getAddress(),c.getPassword(),c.getPhoneNumber(),c.getEmail(),c.getRole());
        return dto;
    }
    public static List<CottageOwnerDTO> MapToListDTOS(List<CottageOwner> cottageOwners){
        List<CottageOwnerDTO> dtos = new ArrayList<>();
        for(CottageOwner c : cottageOwners){
            dtos.add(MapToDTO(c));
        }
        return dtos;
    }
    public static CottageOwner MapDTOToCottageOwner(CottageOwnerDTO dto){
        CottageOwner c = new CottageOwner();
        c.setId(dto.getId());
        c.setEmail(dto.getEmail());
        c.setName(dto.getName());
        c.setPassword(dto.getPassword());
        c.setPhoneNumber(dto.getPhoneNumber());
        c.setSurname(dto.getSurname());
        c.setRole(dto.getRole());
        c.setPassword(dto.getPassword());
        c.setAddress(dto.getAddress());
        return c;
    }
}
