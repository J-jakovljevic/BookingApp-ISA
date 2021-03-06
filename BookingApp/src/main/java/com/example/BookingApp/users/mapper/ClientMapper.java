package com.example.BookingApp.users.mapper;

import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper {
    public static ClientDTO MapToDTO(Client c){
        ClientDTO dto = new ClientDTO(c.getId(),c.getName(),c.getSurname(),
            c.getAddress(),c.getPassword(),c.getPhoneNumber(),c.getEmail(),c.getRole(),c.getUsername(),c.isEnabled());
        return dto;
    }
    public static List<ClientDTO> MapToListDTOS(List<Client> clients){
        List<ClientDTO> dtos = new ArrayList<>();
        for(Client c : clients){
            dtos.add(MapToDTO(c));
        }
        return dtos;
    }
    public static Client MapDTOToClient(ClientDTO dto){
        Client c = new Client();
        c.setEmail(dto.getEmail());
        c.setName(dto.getName());
        c.setPassword(dto.getPassword());
        c.setPhoneNumber(dto.getPhoneNumber());
        c.setSurname(dto.getSurname());
        c.setRole(dto.getRole());
        c.setPassword(dto.getPassword());
        c.setAddress(dto.getAddress());
        c.setEnabled(dto.isEnabled());
        return c;
    }
}
