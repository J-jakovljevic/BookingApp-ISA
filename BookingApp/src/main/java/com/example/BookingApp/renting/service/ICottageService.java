package com.example.BookingApp.renting.service;

import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.model.Cottage;

import java.util.List;

public interface ICottageService {
    Cottage addCottage(CottageDTO dto);
    List<CottageDTO> getAll();
}
