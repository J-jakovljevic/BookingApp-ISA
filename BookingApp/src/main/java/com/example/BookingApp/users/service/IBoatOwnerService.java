package com.example.BookingApp.users.service;

import com.example.BookingApp.users.dto.BoatOwnerDTO;
import com.example.BookingApp.users.model.BoatOwner;

import java.util.List;

public interface IBoatOwnerService {
    void add(BoatOwnerDTO dto);

    List<BoatOwnerDTO> getAll();

    BoatOwnerDTO findById(long id);

    BoatOwnerDTO updateBoatOwner(BoatOwnerDTO dto);

    BoatOwner registerBoatOwner(BoatOwnerDTO dto);
}
