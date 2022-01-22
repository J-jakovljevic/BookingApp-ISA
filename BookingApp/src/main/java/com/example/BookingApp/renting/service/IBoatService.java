package com.example.BookingApp.renting.service;

import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.model.Boat;
import com.example.BookingApp.renting.model.Cottage;

import java.util.List;

public interface IBoatService {
    Boat addBoat(BoatDTO dto);
    List<BoatDTO> getAll();
    List<BoatDTO> search(String searchInput);
    List<BoatDTO> sortByNameAscending();
    List<BoatDTO> sortByNameDescending();
    List<BoatDTO> sortByLocationAscending();
    List<BoatDTO> sortByLocationDescending();
    BoatDTO getById(Long id);


}
