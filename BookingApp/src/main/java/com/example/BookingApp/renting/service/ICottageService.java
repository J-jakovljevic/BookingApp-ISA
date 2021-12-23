package com.example.BookingApp.renting.service;

import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.model.Boat;
import com.example.BookingApp.renting.model.Cottage;

import java.util.List;

public interface ICottageService {
    Cottage addCottage(CottageDTO dto);
    List<CottageDTO> getAll();
    List<CottageDTO> search(String searchInput);
    List<CottageDTO> sortByNameAscending();
    List<CottageDTO> sortByNameDescending();
    List<CottageDTO> sortByLocationAscending();
    List<CottageDTO> sortByLocationDescending();
    CottageDTO getById(Long id);

}
