package com.example.BookingApp.renting.mapper;

import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.model.Boat;

import java.util.ArrayList;
import java.util.List;

public class BoatMapper {

    public static Boat MapDTOToBoat(BoatDTO dto){
        Boat b = new Boat();
        b.setCapacity(dto.getCapacity());
        b.setRules(dto.getRules());
        b.setLength(dto.getLength());
        b.setCancellationTerms(dto.getCancellationTerms());
        b.setMaxSpeed(dto.getMaxSpeed());
        b.setType(dto.getType());
        b.setNavigationEquipment(dto.getNavigationEquipment());
        b.setDescription(dto.getDescription());
        b.setEngineNumber(dto.getEngineNumber());
        b.setName(dto.getName());
        b.setAddress(dto.getAddress());
        return b;
    }

    public static BoatDTO MapToDTO(Boat b){
        BoatDTO dto= new BoatDTO(b.getId(),b.getName(),b.getAddress(),b.getDescription(),b.getType(),b.getLength(),b.getEngineNumber(),
                b.getMaxSpeed(),b.getNavigationEquipment(),b.getCancellationTerms(),
                b.getRules(),b.getCapacity());
        return dto;
    }

    public static List<BoatDTO> MapToListDTO(List<Boat> boats){
        List<BoatDTO> dtos = new ArrayList<BoatDTO>();
        for(Boat b : boats){
            dtos.add(MapToDTO(b));
        }
        return dtos;
    }

    public static List<Boat> MapDTOSToList(List<BoatDTO> dtos){
        List<Boat> boats = new ArrayList<Boat>();
        for(BoatDTO dto : dtos){
            boats.add(MapDTOToBoat(dto));
        }
        return boats;
    }
}
