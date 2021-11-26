package com.example.BookingApp.renting.service;

import com.example.BookingApp.renting.dto.BoatDTO;
import com.example.BookingApp.renting.dto.CottageDTO;
import com.example.BookingApp.renting.model.Boat;
import com.example.BookingApp.renting.model.Cottage;

import java.util.List;

public interface IBoatService {
    Boat addBoat(BoatDTO dto);
    List<Boat> getAll();
}
