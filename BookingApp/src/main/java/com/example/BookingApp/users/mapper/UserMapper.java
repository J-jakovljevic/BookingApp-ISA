package com.example.BookingApp.users.mapper;

import com.example.BookingApp.users.dto.ClientDTO;
import com.example.BookingApp.users.dto.UserDTO;
import com.example.BookingApp.users.model.Client;
import com.example.BookingApp.users.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public UserMapper() {}

    public static UserDTO MapToDTO(User u){
        UserDTO dto = new UserDTO(u.getId(),u.getName(),u.getSurname(),
                u.getAddress(),u.getPassword(),u.getPhoneNumber(),u.getEmail(),u.getRole(),u.getUsername());
        return dto;
    }
    public static List<UserDTO> MapToListDTOS(List<User> users){
        List<UserDTO> dtos = new ArrayList<>();
        for(User u : users){
            dtos.add(MapToDTO(u));
        }
        return dtos;
    }

}

