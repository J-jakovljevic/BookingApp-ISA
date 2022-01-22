package com.example.BookingApp.users.mapper;

import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.dto.ComplaintDTO;
import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.model.Complaint;

import java.util.ArrayList;
import java.util.List;

public class ComplaintMapper {
    public static ComplaintDTO MapToDTO(Complaint c){
        ComplaintDTO dto = new ComplaintDTO(c.getId(),c.getSender().getId(),c.getRentingItem().getId(),c.getDescription());
        return dto;
    }
    public static List<ComplaintDTO> MapToListDTOS(List<Complaint> complaints){
        List<ComplaintDTO> dtos = new ArrayList<>();
        for(Complaint c : complaints){
            dtos.add(MapToDTO(c));
        }
        return dtos;
    }
    public static Complaint MapDTOToComplaint(ComplaintDTO dto){
        Complaint c = new Complaint();
        c.setDescription(dto.getDescription());
        return c;
    }
}
