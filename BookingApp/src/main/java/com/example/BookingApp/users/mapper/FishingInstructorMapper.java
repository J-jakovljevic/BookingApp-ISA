package com.example.BookingApp.users.mapper;

import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.dto.FishingInstructorDTO;
import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.model.FishingInstructor;

import java.util.ArrayList;
import java.util.List;

public class FishingInstructorMapper {
    public FishingInstructorMapper() {}

    public static FishingInstructorDTO MapToDTO(FishingInstructor c){
        FishingInstructorDTO dto = new FishingInstructorDTO(c.getId(),c.getName(),c.getSurname(),
                c.getAddress(),c.getPassword(),c.getPhoneNumber(),c.getEmail(),c.getRole());
        return dto;
    }
    public static List<FishingInstructorDTO> MapToListDTOS(List<FishingInstructor> fishingInstructors){
        List<FishingInstructorDTO> dtos = new ArrayList<>();
        for(FishingInstructor f: fishingInstructors){
            dtos.add(MapToDTO(f));
        }
        return dtos;
    }
    public static FishingInstructor MapDTOToFishingInstructor(FishingInstructorDTO dto){
        FishingInstructor f = new FishingInstructor();
        f.setEmail(dto.getEmail());
        f.setName(dto.getName());
        f.setPassword(dto.getPassword());
        f.setPhoneNumber(dto.getPhoneNumber());
        f.setSurname(dto.getSurname());
        f.setRole(dto.getRole());
        return f;
    }
}
