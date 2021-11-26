package com.example.BookingApp.renting.mapper;

import com.example.BookingApp.renting.dto.FishingInstructorClassDTO;
import com.example.BookingApp.renting.model.FishingInstructorClass;
import com.example.BookingApp.users.mapper.AddressMapper;
import com.example.BookingApp.users.service.IFishingInstructorService;

import java.util.ArrayList;
import java.util.List;

public class FishingInstructorClassMapper {

    public static FishingInstructorClass MapDTOToFishingInstructorClass(FishingInstructorClassDTO dto){
        FishingInstructorClass f = new FishingInstructorClass();
        f.setInstructorBiography(dto.getInstructorBiography());
        f.setCapacity(dto.getCapacity());
        f.setRules(dto.getRules());
        f.setDescription(dto.getDescription());
        f.setName(dto.getName());
        return f;
    }

    public static FishingInstructorClassDTO MapToDTO(FishingInstructorClass f){
        FishingInstructorClassDTO dto= new FishingInstructorClassDTO(f.getId(),f.getName(), AddressMapper.MaptoDTO(f.getAddress()),f.getDescription(), f.getInstructorBiography(), f.getCapacity(),
                f.getFishingInstructor().getId(),f.getInstructorBiography());
        return dto;
    }

    public static List<FishingInstructorClassDTO> MapToListDTO(List<FishingInstructorClass> fishingInstructorClasses){
        List<FishingInstructorClassDTO> dtos = new ArrayList<FishingInstructorClassDTO>();
        for(FishingInstructorClass f : fishingInstructorClasses){
            dtos.add(MapToDTO(f));
        }
        return dtos;
    }

    public static List<FishingInstructorClass> MapDTOSToList(List<FishingInstructorClassDTO> dtos){
        List<FishingInstructorClass> fishingInstructorClasses = new ArrayList<FishingInstructorClass>();
        for(FishingInstructorClassDTO dto : dtos){
            fishingInstructorClasses.add(MapDTOToFishingInstructorClass(dto));
        }
        return fishingInstructorClasses;
    }
}
