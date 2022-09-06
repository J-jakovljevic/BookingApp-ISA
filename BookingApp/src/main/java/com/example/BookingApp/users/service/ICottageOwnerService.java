package com.example.BookingApp.users.service;

import com.example.BookingApp.users.dto.CottageOwnerDTO;
import com.example.BookingApp.users.model.CottageOwner;

import java.util.List;

public interface ICottageOwnerService {
    void add(CottageOwnerDTO dto);

    List<CottageOwnerDTO> getAll();

    CottageOwnerDTO findById(long id);

    CottageOwnerDTO updateCottageOwner(CottageOwnerDTO dto);

    CottageOwner registerCottageOwner(CottageOwnerDTO dto);
}
