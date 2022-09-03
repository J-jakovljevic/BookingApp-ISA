package com.example.BookingApp.reservations.mapper;

import com.example.BookingApp.renting.mapper.AdditionalServiceMapper;
import com.example.BookingApp.renting.mapper.RentingItemMapper;
import com.example.BookingApp.reservations.dto.RevisionDTO;
import com.example.BookingApp.reservations.model.Revision;
import com.example.BookingApp.users.mapper.ClientMapper;

import java.util.ArrayList;
import java.util.List;

public class RevisionMapper {
    public static Revision MapDTOToRevision(RevisionDTO dto){
        Revision r = new Revision();
        r.setGrade(dto.getGrade());
        r.setDescription(dto.getDescription());
        r.setReservationId(dto.getReservationId());
        return r;
    }

    public static RevisionDTO MapToDTO(Revision r){
        RevisionDTO dto= new RevisionDTO(r.getId(),r.getClient().getId(), r.getRentingItem().getId(),r.getGrade(),r.getDescription(), r.getReservationId());
        return dto;
    }

    public static List<RevisionDTO> MapToListDTO(List<Revision> Revisions){
        List<RevisionDTO> dtos = new ArrayList<RevisionDTO>();
        for(Revision r  : Revisions){
            dtos.add(MapToDTO(r));
        }
        return dtos;
    }

    public static List<Revision> MapDTOSToList(List<RevisionDTO> dtos){
        List<Revision> Revisions = new ArrayList<Revision>();
        for(RevisionDTO dto : dtos){
            Revisions.add(MapDTOToRevision(dto));
        }
        return Revisions;
    }
}
