package com.example.BookingApp.users.mapper;
import com.example.BookingApp.users.dto.DeleteAccountRequestDTO;
import com.example.BookingApp.users.model.DeleteAccountRequest;

import java.util.ArrayList;
import java.util.List;

public class DeleteAccountRequestMapper {
    public static DeleteAccountRequestDTO MapToDTO(DeleteAccountRequest d){
        DeleteAccountRequestDTO dto = new DeleteAccountRequestDTO(d.getId(),d.getDescription(),d.isApproved(),d.getClient().getId());
        return dto;
    }

    public static DeleteAccountRequest MapDTOToDeleteAccountRequest(DeleteAccountRequestDTO dto){
        DeleteAccountRequest d = new DeleteAccountRequest();
        d.setApproved(dto.isApproved());
        d.setDescription(dto.getDescription());
        return d;
    }
    public static List<DeleteAccountRequestDTO> MapToListDTOS(List<DeleteAccountRequest> requests){
        List<DeleteAccountRequestDTO> dtos = new ArrayList<>();
        for(DeleteAccountRequest d : requests){
            dtos.add(MapToDTO(d));
        }
        return dtos;
    }
}
