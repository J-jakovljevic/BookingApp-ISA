package com.example.BookingApp.users.mapper;

import com.example.BookingApp.users.dto.AddressDTO;
import com.example.BookingApp.users.model.Address;

public class AddressMapper {
    public AddressMapper() {}

    public static AddressDTO MaptoDTO(Address address){
        AddressDTO dto = new AddressDTO(address.getId(), address.getStreet(), address.getCity(),
                           address.getLatitude(), address.getLongitude(), address.getState());
        return dto;
    }

    public static Address MapDTOToAddress(AddressDTO dto){
        Address a = new Address();
        a.setCity(dto.getCity());
        a.setLatitude(dto.getLatitude());
        a.setLongitude(dto.getLongitude());
        a.setCity(dto.getCity());
        a.setStreet(dto.getStreet());
        a.setState(dto.getState());
        return a;
    }
}
