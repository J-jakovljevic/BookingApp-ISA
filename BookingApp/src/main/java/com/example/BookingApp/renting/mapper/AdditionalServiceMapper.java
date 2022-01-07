package com.example.BookingApp.renting.mapper;

import com.example.BookingApp.renting.dto.AdditionalServiceDTO;
import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.model.AdditionalService;
import com.example.BookingApp.renting.model.Boat;

import java.util.ArrayList;
import java.util.List;

public class AdditionalServiceMapper {
    public static AdditionalService MapDTOToAdditionalService(AdditionalServiceDTO dto){
        AdditionalService a = new AdditionalService();
        a.setDescription(dto.getDescription());
        return a;
    }

    public static AdditionalServiceDTO MapToDTO(AdditionalService a){
        AdditionalServiceDTO dto= new AdditionalServiceDTO(a.getId(),a.getRentingItem().getId(),a.getDescription());
        return dto;
    }

    public static List<AdditionalServiceDTO> MapToListDTO(List<AdditionalService> additionalServices){
        List<AdditionalServiceDTO> dtos = new ArrayList<AdditionalServiceDTO>();
        for(AdditionalService a : additionalServices){
            dtos.add(MapToDTO(a));
        }
        return dtos;
    }

    public static List<AdditionalService> MapDTOSToList(List<AdditionalServiceDTO> dtos){
        List<AdditionalService> additionalServices = new ArrayList<AdditionalService>();
        for(AdditionalServiceDTO dto : dtos){
            additionalServices.add(MapDTOToAdditionalService(dto));
        }
        return additionalServices;
    }
}
