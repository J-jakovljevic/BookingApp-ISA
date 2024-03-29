package com.example.BookingApp.renting.mapper;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.model.Cottage;
import com.example.BookingApp.users.mapper.CottageOwnerMapper;
import com.example.BookingApp.users.model.CottageOwner;
import com.example.BookingApp.users.service.ICottageOwnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CottageMapper {

    public static Cottage MapDTOToCottage(CottageDTO dto){
        Cottage c = new Cottage();
        c.setId(dto.getId());
        c.setName(dto.getName());
        c.setDescription(dto.getDescription());
        c.setRules(dto.getRules());
        c.setCapacity(dto.getCapacity());
        return c;
    }

    public static CottageDTO MapToDTO(Cottage c){
        CottageDTO dto= new CottageDTO(c.getId(),c.getName(),c.getAddress(),c.getDescription(),
                c.getRules(),c.getCapacity(), c.getCottageOwner().getId());
        return dto;
    }

    public static List<CottageDTO> MapToListDTO(List<Cottage> cottages){
        List<CottageDTO> dtos = new ArrayList<CottageDTO>();
        for(Cottage c : cottages){
            dtos.add(MapToDTO(c));
        }
        return dtos;
    }

    public static List<Cottage> MapDTOSToList(List<CottageDTO> dtos){
        List<Cottage> cottages = new ArrayList<Cottage>();
        for(CottageDTO dto : dtos){
            cottages.add(MapDTOToCottage(dto));
        }
        return cottages;
    }
}
